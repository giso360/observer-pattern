package com.company.observer;

import com.company.observer.events.PriceChangeEvent;
import com.company.observer.events.StockChangeEvent;
import com.company.observer.listeners.EventListener;
import com.company.observer.listeners.PriceListener;
import com.company.observer.listeners.StockVolumeListener;
import com.company.observer.model.Product;
import com.company.observer.util.StoreUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StoreService implements IEventSubscriber {

    private static final Product USB_PRODUCT = new Product("0010","KINGSTON USB", 10, 1000);

    private static final Store STORE = new Store(Arrays.asList(USB_PRODUCT));

    private final PriceListener priceListener = new PriceListener();

    private final StockVolumeListener stockVolumeListener = new StockVolumeListener();

    private List<EventListener> eventListeners = new ArrayList<>();

    public void setEventListeners(List<EventListener> eventListeners) {
        this.eventListeners = eventListeners;
    }

    public PriceListener getPriceListener() {
        return priceListener;
    }

    public StockVolumeListener getStockVolumeListener() {
        return stockVolumeListener;
    }

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

        this.eventListeners.add(priceListener);
        this.eventListeners.add(stockVolumeListener);

        EventManager eventManager = STORE.getEventManager();
        eventManager.subscribe(PriceChangeEvent.class, this);
        eventManager.subscribe(StockChangeEvent.class, this);

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

    @Override
    public List<EventListener> getEventListeners() {
        return this.eventListeners;
    }
}
