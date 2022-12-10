package com.company.observer.listeners;

import com.company.observer.log.Logger;

import java.io.IOException;

public class StockVolumeListener implements EventListener {


    private static final Logger LOGGER = Logger.getLogger(StockVolumeListener.class);

    public StockVolumeListener() {
    }

    @Override
    public void update(String eventType, Object value) throws IOException {
        String message = "EVENT TYPE: " + eventType + " - NEW STOCK VOLUME:  " + value.toString();
        LOGGER.INFO(message);
    }

}
