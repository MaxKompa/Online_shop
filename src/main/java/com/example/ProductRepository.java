package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private List<Product> products = new ArrayList<>();


    public ProductRepository() {
        products.add(new Product(1, "Laptop", 1000.0));
        products.add(new Product(2, "Smartphone", 500.0));
        products.add(new Product(3, "Headphones", 100.0));
    }


    public void addProduct(Product product) {
        products.add(product);
    }


    public List<Product> getAllProducts() {
        return products;
    }


    public Optional<Product> getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }


    public void updateProduct(Product updatedProduct) {
        getProductById(updatedProduct.getId()).ifPresent(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
        });
    }


    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}

