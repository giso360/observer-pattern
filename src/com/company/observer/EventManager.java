package com.company.observer;

import com.company.observer.listeners.EventListener;

import java.io.IOException;
import java.util.*;

public class EventManager {

    private final Map<String, List<EventListener>> eventListeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation: operations){
            this.eventListeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener){
        this.eventListeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener){
        List<EventListener> eventListenersForEventType = this.eventListeners.get(eventType);
        eventListenersForEventType.remove(listener);
    }

    public void notify(String eventType, int newPrice) throws IOException {
        List<com.company.observer.listeners.EventListener> listeners = this.eventListeners.get(eventType);
        for (com.company.observer.listeners.EventListener listener: listeners){
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
