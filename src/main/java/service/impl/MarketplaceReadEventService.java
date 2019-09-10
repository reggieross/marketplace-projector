package service.impl;

import domain.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import rest.ICatalogClient;
import service.IReadEventService;
import javax.jms.JMSException;


@Service
public class MarketplaceReadEventService implements IReadEventService {
    private Logger logger = LoggerFactory.getLogger(MarketplaceReadEventService.class);

    private ICatalogClient catalogClient;

    public MarketplaceReadEventService(
        @Autowired ICatalogClient catalogClient
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
            logger.error("Encountered error while parsing message.",ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }
}
