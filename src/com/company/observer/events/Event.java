package com.company.observer.events;

public class Event {

    private EOperation eOperation;

    public Event(EOperation operation) {
        this.eOperation = operation;
    }

    public EOperation geteOperation() {
        return eOperation;
    }

    public void seteOperation(EOperation eOperation) {
        this.eOperation = eOperation;
    }

}
