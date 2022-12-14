package com.company.config;

import com.company.observer.model.Product;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreConfig {
    private static final String PROJECT_ROOT_FOLDER = System.getProperty("user.dir");


    private static final String PATH_SEPARATOR = "\\";

    private static final String FILENAME = "store.xml";

    private static final String CONFIG_FILE_PATH = PROJECT_ROOT_FOLDER + PATH_SEPARATOR + FILENAME;

    private final Document document;

    private final Element rootElement;

    private final List<Product> products = new ArrayList<>();

    public StoreConfig() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(CONFIG_FILE_PATH);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        this.document = dBuilder.parse(inputFile);
        this.document.getDocumentElement().normalize();
        this.rootElement = this.document.getDocumentElement();
        parseStoreConfig();
    }

    private void parseStoreConfig() throws ParserConfigurationException, IOException, SAXException {
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        NodeList productNodes = document.getElementsByTagName("product");

        for (int i = 0; i < productNodes.getLength(); i++) {
            Node productNode = productNodes.item(i);
            Product product = productNodeToProduct(productNode);
            products.add(product);
        }
    }

    private Product productNodeToProduct(Node productNode){
        Product product = new Product();

        product.setProductId(productNode.getAttributes().getNamedItem("productid").getNodeValue());

        NodeList productFields = productNode.getChildNodes();

        for (int j = 0; j < productFields.getLength(); j++) {

            if (productFields.item(j).getNodeName().equalsIgnoreCase("productName")) {
                product.setProductName(productFields.item(j).getTextContent());
            }

            else if (productFields.item(j).getNodeName().equalsIgnoreCase("price")) {
                product.setPrice(Integer.parseInt(productFields.item(j).getTextContent()));
            }

            else if (productFields.item(j).getNodeName().equalsIgnoreCase("stockVolume")) {
                product.setStockVolume(Integer.parseInt(productFields.item(j).getTextContent()));
            }
        }

        return product;
    }

    public List<Product> getProducts() {
        return products;
    }
}
