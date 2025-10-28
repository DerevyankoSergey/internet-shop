package shop.ui;

import shop.model.*;
import shop.service.ShopService;

public class ConsoleUI {
    public static void main(String[] args) {
        ShopService shop = new ShopService();

        Category electronics = new Category("Электроника");
        Category books = new Category("Книги");

        Product p1 = new Product("Смартфон", 30000, electronics);
        Product p2 = new Product("Книга JAVA", 800, books);
        shop.addProduct(p1);
        shop.addProduct(p2);

        Customer c1 = new Customer("Алексей");
        c1.addPurchase(p1);
        Customer c2 = new Customer("Мария");
        c2.addPurchase(p2);
        shop.addCustomer(c1);
        shop.addCustomer(c2);

        System.out.println("Товары в категории Электроника:");
        shop.findByCategory(electronics).forEach(System.out::println);

        System.out.println("\nПокупатели с тратой > 10000:");
        shop.filterByMinSpent(10000).forEach(c ->
            System.out.println(c.getName() + " - " + c.getTotalSpent() + " руб."));
    }
}
