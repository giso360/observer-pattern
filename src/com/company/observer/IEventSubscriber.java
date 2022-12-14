package com.company.observer;

import com.company.observer.listeners.EventListener;

import java.util.List;

public interface IEventSubscriber {

    List<EventListener> getEventListeners();

}
