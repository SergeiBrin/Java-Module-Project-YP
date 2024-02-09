package utils;

import model.Product;

public class ProductFactory {

    public static Product createProduct(String productName, double cost) {
        return new Product(productName, cost);
    }
}
