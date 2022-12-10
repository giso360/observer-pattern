package com.company.observer.model;

public class Product {

    private String productId;

    private String productName;

    private int price;

    private int stockVolume;

    public Product(String productId, String productName, int price, int stockVolume) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockVolume = stockVolume;
    }

    public Product() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockVolume() {
        return stockVolume;
    }

    public void setStockVolume(int stockVolume) {
        this.stockVolume = stockVolume;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stockVolume=" + stockVolume +
                '}';
    }
}
