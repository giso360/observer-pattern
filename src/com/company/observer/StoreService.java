package com.company.observer;

import com.company.observer.listeners.PriceListener;
import com.company.observer.listeners.StockVolumeListener;
import com.company.observer.model.Product;
import com.company.observer.util.StoreUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StoreService {

    private static final Product USB_PRODUCT = new Product("0010","KINGSTON USB", 10, 1000);

    private static final Store STORE = new Store(Arrays.asList(USB_PRODUCT));

    private final EventManager eventManager = STORE.getEventManager();

    private Runnable updater = new Runnable() {

        @Override
        public void run() {
            try {
                StoreService.this.doPriceChange();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    };

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    public StoreService() {

        PriceListener priceListener = new PriceListener();
        StockVolumeListener stockVolumeListener = new StockVolumeListener();

        eventManager.subscribe(EOperation.CHANGE_PRICE.getOperationName(), priceListener);
        eventManager.subscribe(EOperation.CHANGE_STOCK_VALUE.getOperationName(), stockVolumeListener);

        executor.scheduleAtFixedRate(updater, 0, 2, TimeUnit.SECONDS);
    }

    public void doPriceChange() throws IOException {
        int newPrice = StoreUtil.generateRandomPrice();
        STORE.getProducts().get(0).setPrice(newPrice);
        STORE.changePrice(newPrice);
        if (StoreUtil.generateBuyFlag()){
            doStockVolumeChange();
        }
    }

    private void doStockVolumeChange() throws IOException {
        int previousVolume = STORE.getProducts().get(0).getStockVolume();
        STORE.getProducts().get(0).setStockVolume(previousVolume - 1);
        STORE.changeStockVolume(previousVolume - 1);
    }

}
