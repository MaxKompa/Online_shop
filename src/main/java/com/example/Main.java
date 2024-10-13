package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Показати усі товари");
            System.out.println("2. Добавити товар у кошик");
            System.out.println("3. Видалити товар з кошику");
            System.out.println("4. Показати вміст кошику");
            System.out.println("5. Вихід");
            System.out.print("Виберіть операцію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Активні товари:");
                    for (Product product : productRepository.getAllProducts()) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Введіть id товара, щоб додати до кошика: ");
                    int productIdToAdd = scanner.nextInt();
                    cart = context.getBean(Cart.class);
                    productRepository.getProductById(productIdToAdd)
                            .ifPresentOrElse(cart::addProduct,
                                    () -> System.out.println("Товар не знайден."));
                    break;
                case 3:
                    System.out.print("Введіть id товару, щоб видалити з кошика: ");
                    int productIdToRemove = scanner.nextInt();
                    cart = context.getBean(Cart.class);
                    cart.removeProduct(productIdToRemove);
                    break;
                case 4:
                    cart = context.getBean(Cart.class);
                    cart.showCart();
                    break;
                case 5:
                    System.out.println("Вихід...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неправильна операція. Спробуйте ще раз.");
            }
        }
    }
}

