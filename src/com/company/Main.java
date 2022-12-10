package com.company;

import com.company.config.StoreConfig;
import com.company.observer.Store;
import com.company.observer.log.Logger;
import com.company.observer.StoreService;
import com.company.observer.model.Product;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        StoreService storeService = new StoreService();
        StoreConfig storeConfig = new StoreConfig();
        List<Product> productList = storeConfig.getProducts();
        productList.forEach(product -> System.out.println(product.toString()));
    }

}
