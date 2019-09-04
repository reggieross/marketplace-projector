package service.impl;

import domain.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import service.IReadEventService;
import javax.jms.JMSException;


@Service
public class MarketplaceReadEventService implements IReadEventService {
    private Logger logger = LoggerFactory.getLogger(MarketplaceReadEventService.class);


    @JmsListener(destination = "${sqs.marketplace.queuename}")
    public void processRequest(String requestJSON) throws JMSException {
        logger.info("Received new message");
        try {
            ProductRequest request = ProductRequest.fromJSON(requestJSON);
            logger.info(requestJSON);
        } catch (Exception ex) {
            logger.error("Encountered error while parsing message.",ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }
}
