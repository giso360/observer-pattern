package com.company.observer.listeners;

import com.company.observer.events.EOperation;
import com.company.observer.events.Event;

import java.io.IOException;

public interface EventListener {

    EOperation getOperation();



    void update(String eventType, Object value) throws IOException;

    void update2(EOperation eventType, Event evt) throws IOException;

}
