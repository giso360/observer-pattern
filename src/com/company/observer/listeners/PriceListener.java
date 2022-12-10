package com.company.observer.listeners;

import com.company.observer.log.Logger;

import java.io.IOException;

public class PriceListener implements EventListener {

    private static final Logger LOGGER = Logger.getLogger(PriceListener.class);

    public PriceListener() {
    }

    @Override
    public void update(String eventType, Object value) throws IOException {
        String message = "EVENT TYPE: " + eventType + " - NEW PRICE: " + value;
        LOGGER.INFO(message);
    }

}
