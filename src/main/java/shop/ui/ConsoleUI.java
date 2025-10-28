package shop.ui;

import shop.model.*;
import shop.service.ShopService;

public class ConsoleUI {
    public static void main(String[] args) {
        ShopService shop = new ShopService();

        // === ????????? ===
        Category electronics = new Category("???????????");
        Category books = new Category("?????");
        Category clothing = new Category("??????");
        Category food = new Category("????????");

        // === ?????? ===
        Product p1 = new Product("????????", 30000, electronics);
        Product p2 = new Product("???????", 75000, electronics);
        Product p3 = new Product("????? 'Java'", 800, books);
        Product p4 = new Product("????? 'Python'", 1200, books);
        Product p5 = new Product("????????", 1500, clothing);
        Product p6 = new Product("??????", 5000, clothing);
        Product p7 = new Product("????", 50, food);
        Product p8 = new Product("??????", 80, food);

        shop.addProduct(p1); shop.addProduct(p2); shop.addProduct(p3); shop.addProduct(p4);
        shop.addProduct(p5); shop.addProduct(p6); shop.addProduct(p7); shop.addProduct(p8);

        // === ?????????? ===
        Customer c1 = new Customer("???????");
        Customer c2 = new Customer("?????");
        Customer c3 = new Customer("???????");
        Customer c4 = new Customer("?????");
        Customer c5 = new Customer("??????");

        c1.addPurchase(p1); c1.addPurchase(p2); c1.addPurchase(p3);
        c2.addPurchase(p4); c2.addPurchase(p5);
        c3.addPurchase(p6); c3.addPurchase(p8);
        c4.addPurchase(p7);
        c5.addPurchase(p1); c5.addPurchase(p5); c5.addPurchase(p6);

        shop.addCustomer(c1); shop.addCustomer(c2); shop.addCustomer(c3);
        shop.addCustomer(c4); shop.addCustomer(c5);

        System.out.println("=== ?????? ? ????????? '???????????' ===");
        shop.findByCategory(electronics).forEach(System.out::println);

        System.out.println("\n=== ?????? ? ????????? '?????' ===");
        shop.findByCategory(books).forEach(System.out::println);

        System.out.println("\n=== ?????? ? ????????? '??????' ===");
        shop.findByCategory(clothing).forEach(System.out::println);

        System.out.println("\n=== ?????????? ? ??????? > 50000 ???. ===");
        shop.filterByMinSpent(50000).forEach(c ->
            System.out.println(c.getName() + " - " + c.getTotalSpent() + " ???."));

        System.out.println("\n=== ?????????? ? ??????? > 10000 ???. ===");
        shop.filterByMinSpent(10000).forEach(c ->
            System.out.println(c.getName() + " - " + c.getTotalSpent() + " ???."));

        System.out.println("\n=== ?????????? ? ??????? > 5000 ???. ===");
        shop.filterByMinSpent(5000).forEach(c ->
            System.out.println(c.getName() + " - " + c.getTotalSpent() + " ???."));
    }
}
