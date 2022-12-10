package com.company.observer;

import com.company.observer.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Store {

    private List<Product> products;

    private final EventManager eventManager;

    public Store(List<Product> products) {
        List<String> operationsToEventManager = new ArrayList<>();
        EnumSet<EOperation> eOperations = EnumSet.allOf(EOperation.class);
        for (EOperation operation: eOperations){
            operationsToEventManager.add(operation.getOperationName());
        }
        this.eventManager = new EventManager(operationsToEventManager.toArray(new String[0]));
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void changePrice(int newPrice) throws IOException {
        eventManager.notify(EOperation.CHANGE_PRICE.getOperationName(), newPrice);
    }

    public void changeStockVolume(int newStockVolume) throws IOException {
        eventManager.notify(EOperation.CHANGE_STOCK_VALUE.getOperationName(), newStockVolume);
    }
}
