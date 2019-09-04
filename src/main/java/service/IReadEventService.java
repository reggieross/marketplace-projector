package service;

import javax.jms.JMSException;

public interface IReadEventService {
    void processRequest(String requestJSON) throws JMSException;
}
