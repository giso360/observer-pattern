package com.company.observer.listeners;

import com.company.observer.EOperation;
import com.company.observer.events.BusinessEvent;

import java.io.IOException;

public interface EventListener {


    void update(String eventType, Object value) throws IOException;
//    void update2(EOperation eventType, Object value) throws IOException;

}
