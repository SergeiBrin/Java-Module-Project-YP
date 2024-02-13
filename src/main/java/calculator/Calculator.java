package calculator;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class Calculator {
    private final List<Product> products = new ArrayList<>();
    private static double totalPrice;

    public void add(Product product) {
        products.add(product);
        calculateTotalPrice(product.getCost());
    }

    public void printAllAddedProducts() {
        if (products.isEmpty()) {
            System.out.println("Список товаров пуст");
            return;
        }

        System.out.println("Добавленные товары:");
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    public String calculatePriceForOnePerson(int numberOfPerson) {
        double price = totalPrice / numberOfPerson;
        return String.format("%.2f %s\n", price, getDeclensionByNumber(price));
    }

    private void calculateTotalPrice(double price) {
        totalPrice += price;
    }

    private String getDeclensionByNumber(double price) {
        double roundedPrice = Math.floor(price);
        String result;

        int lastTwoDigit = (int) roundedPrice % 100;
        if (lastTwoDigit >= 11 && roundedPrice <= 14) {
            return "рублей";
        }

        int lastDigit = (int) roundedPrice % 10;
        if (lastDigit == 1) {
            result = "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            result = "рубля";
        } else {
            result = "рублей";
        }

        return result;
    }
}
