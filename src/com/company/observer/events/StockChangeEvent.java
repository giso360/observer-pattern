package com.company.observer.events;

public class StockChangeEvent extends BusinessEvent{

    private String productName;

    private int oldStockVolume;

    private int newStockVolume;

    private int stockVolumeDifference;

    public StockChangeEvent(EOperation eOperation, String productName, int oldStockVolume, int newStockVolume) {
        super(eOperation);
        this.productName = productName;
        this.oldStockVolume = oldStockVolume;
        this.newStockVolume = newStockVolume;
        this.stockVolumeDifference = this.newStockVolume - this.oldStockVolume;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOldStockVolume() {
        return oldStockVolume;
    }

    public void setOldStockVolume(int oldStockVolume) {
        this.oldStockVolume = oldStockVolume;
    }

    public int getNewStockVolume() {
        return newStockVolume;
    }

    public void setNewStockVolume(int newStockVolume) {
        this.newStockVolume = newStockVolume;
    }
}
