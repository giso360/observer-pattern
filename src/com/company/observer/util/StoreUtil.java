package com.company.observer.util;

public class StoreUtil {

    public static int generateRandomPrice() {
        return (int) Math.round(10 + Math.random() * (11));
    }

    public static boolean generateBuyFlag() {
        return (int) Math.round(Math.random() * (1)) == 1;
    }

}
