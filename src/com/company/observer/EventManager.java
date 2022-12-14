package com.company.observer;

import com.company.observer.events.EOperation;
import com.company.observer.events.Event;
import com.company.observer.events.PriceChangeEvent;
import com.company.observer.events.StockChangeEvent;
import com.company.observer.listeners.EventListener;
import java.io.IOException;
import java.util.*;

public class EventManager {

    private static final Map<Class<? extends Event>, EOperation> OPERATION_CLASS_MAP = new HashMap<>();

    private final Map<String, List<EventListener>> eventListeners = new HashMap<>();

    public EventManager() {
        this(getOperationsToEvtMgr().toArray(new String[0]));
    }

    private EventManager(String... operations) {
        registerEvents();
        for (String operation: operations){
            this.eventListeners.put(operation, new ArrayList<>());
        }
    }

    private static List<String> getOperationsToEvtMgr() {
        List<String> operationsToEventManager = new ArrayList<>();
        EnumSet<EOperation> eOperations = EnumSet.allOf(EOperation.class);
        for (EOperation operation: eOperations){
            operationsToEventManager.add(operation.getOperationName());
        }
        return operationsToEventManager;
    }


    private void registerEvents() {
        OPERATION_CLASS_MAP.put(PriceChangeEvent.class, EOperation.CHANGE_PRICE);
        OPERATION_CLASS_MAP.put(StockChangeEvent.class, EOperation.CHANGE_STOCK_VALUE);
    }

    public void subscribe(String eventType, EventListener listener){
        this.eventListeners.get(eventType).add(listener);
    }

    public void subscribe(Class<? extends Event> clazz, IEventSubscriber eventSubscriber){
        EOperation eOperation = OPERATION_CLASS_MAP.get(clazz);
        List<EventListener> listenersList = eventSubscriber.getEventListeners();
        for (EventListener eventListener: listenersList) {
            if (eventListener.getOperation() == eOperation) {
                this.eventListeners.get(eOperation.getOperationName()).add(eventListener);
            }
        }
    }

    public void unsubscribe(String eventType, EventListener listener){
        List<EventListener> eventListenersForEventType = this.eventListeners.get(eventType);
        eventListenersForEventType.remove(listener);
    }

    public void notify(String eventType, int newPrice) throws IOException {
        List<EventListener> listeners = this.eventListeners.get(eventType);
        for (EventListener listener: listeners){
            listener.update(eventType, newPrice);
        }
    }

    public String[] getEventManagerOperations() {
        List<String> eventManagerOperations = new ArrayList<>(eventListeners.keySet());
        return eventManagerOperations.toArray(String[]::new);
    }

    public List<EventListener> getEventListenerForOperation(String operationName) {
        return this.eventListeners.get(operationName);
    }

}
