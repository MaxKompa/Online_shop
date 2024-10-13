package com.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems = new ArrayList<>();


    public void addProduct(Product product) {
        cartItems.add(product);
        System.out.println("Товар доданий до кошику: " + product);
    }


    public void removeProduct(int productId) {
        cartItems.removeIf(product -> product.getId() == productId);
        System.out.println("Товар з id " + productId + " видалений з кошику.");
    }


    public void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Кошик пуст.");
        } else {
            System.out.println("У кошику знаходяться:");
            for (Product product : cartItems) {
                System.out.println(product);
            }
        }
    }
}

