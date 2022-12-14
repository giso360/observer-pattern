package com.company.observer.listeners;

import com.company.observer.events.EOperation;
import com.company.observer.events.Event;
import com.company.observer.log.Logger;

import java.io.IOException;

public class StockVolumeListener implements EventListener {


    private static final Logger LOGGER = Logger.getLogger(StockVolumeListener.class);

    private final EOperation eOperation = EOperation.CHANGE_STOCK_VALUE;

    public StockVolumeListener() {
    }

    public EOperation geteOperation() {
        return eOperation;
    }

    @Override
    public EOperation getOperation() {
        return eOperation;
    }

    @Override
    public void update(String eventType, Object value) throws IOException {
        String message = "EVENT TYPE: " + eventType + " - NEW STOCK VOLUME:  " + value.toString(); // perform logging action upon receiving event
        LOGGER.INFO(message);
    }

    @Override
    public void update2(EOperation eventType, Event evt) throws IOException {

    }

}
