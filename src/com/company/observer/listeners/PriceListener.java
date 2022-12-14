package com.company.observer.listeners;

import com.company.observer.events.EOperation;
import com.company.observer.events.Event;
import com.company.observer.events.PriceChangeEvent;
import com.company.observer.log.Logger;

import java.io.IOException;

public class PriceListener implements EventListener {

    private static final Logger LOGGER = Logger.getLogger(PriceListener.class);

    private final EOperation eOperation = EOperation.CHANGE_PRICE;

    public PriceListener() {
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
        String message = "EVENT TYPE: " + eventType + " - NEW PRICE: " + value; // perform logging action upon receiving event
        LOGGER.INFO(message);
    }

    @Override
    public void update2(EOperation eventType, Event evt) throws IOException {
        if (evt instanceof PriceChangeEvent){
            String message = "EVENT TYPE: " + eventType.getOperationName() + " - OLD PRICE: " + ((PriceChangeEvent) evt).getOldPrice() + " - NEW PRICE: " + ((PriceChangeEvent) evt).getNewPrice(); // perform logging action upon receiving event
            LOGGER.INFO(message);
        }
    }

}
