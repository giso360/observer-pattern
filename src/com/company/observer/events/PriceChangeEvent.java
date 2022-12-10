package com.company.observer.events;

public class PriceChangeEvent implements BusinessEvent{

    private String productName;

    private int oldPrice;

    private int newPrice;

    private int priceDifference;

    public PriceChangeEvent(String productName, int oldPrice, int newPrice) {
        this.productName = productName;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.priceDifference = this.newPrice - this.oldPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public int getPriceDifference() {
        return priceDifference;
    }

    public void setPriceDifference(int priceDifference) {
        this.priceDifference = priceDifference;
    }
}
