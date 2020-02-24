package com.rross.marketplace.service;

import javax.jms.JMSException;

public interface ISQSEventService {
    void processRequest(String requestJSON) throws JMSException;
}
