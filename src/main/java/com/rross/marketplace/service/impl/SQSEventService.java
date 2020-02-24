package com.rross.marketplace.service.impl;

import com.rross.marketplace.domain.model.ProductRequest;
import com.rross.marketplace.projector.IProjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import com.rross.marketplace.service.ISQSEventService;
import javax.jms.JMSException;


@Service
public class SQSEventService implements ISQSEventService {
    private Logger logger = LoggerFactory.getLogger(SQSEventService.class);

    private IProjector catalogClient;

    public SQSEventService(
        @Autowired IProjector catalogClient
    ) {
        this.catalogClient = catalogClient;
    }

    @JmsListener(destination = "${sqs.marketplace.queuename}")
    public void processRequest(String requestJSON) throws JMSException {
        logger.info("Received new message");
        try {
            ProductRequest request = ProductRequest.fromJSON(requestJSON);
            catalogClient.createProduct(request.getProduct());
        } catch (Exception ex) {
            logger.error("Encountered error while parsing message: " + requestJSON,ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }
}
