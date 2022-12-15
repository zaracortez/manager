package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void AddAllProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(5, "My life", "Edward Luk", 500);
        Book book2 = new Book(8, "Math for Us", "Peterson", 1000);
        Book book3 = new Book(10, "About dogs", "Gerasimova", 740);
        Smartphone smartphone1 = new Smartphone(10, "iPhone14", 150000, "Apple");
        Smartphone smartphone2 = new Smartphone(3, "SamsungA10", 40000, "LLC Samsung");
        Smartphone smartphone3 = new Smartphone(3, "XiaomiRedmi10", 35000, "Xiaomi");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1,book2,book3,smartphone1,smartphone2,smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchProductsBook() {
        Book book1 = new Book(10, "About dogs", "Gerasimova", 1500);
        Book book2 = new Book(3, "My world", "Corovina", 800);
        Book book3 = new Book(7, "Owl", "Nekrasov", 650);
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Owl");
        Book[] expected = {book3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SearchProductsSmartphone() {
        Smartphone smartphone1 = new Smartphone(10, "iPhone14", 150000, "Apple");
        Smartphone smartphone2 = new Smartphone(3, "SamsungA10", 40000, "LLC Samsung");
        Smartphone smartphone3 = new Smartphone(3, "XiaomiRedmi10", 35000, "Xiaomi");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("iPhone14");
        Smartphone[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchProductsNotMatch() {
        Book book1 = new Book(10, "About dogs", "Gerasimova", 1500);
        Book book2 = new Book(3, "My world", "Corovina", 800);
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);


        Product[] actual = manager.searchBy("cat");
        ProductRepository[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void AddDifferentProducts() {
        Book book1 = new Book(12, "About dogs", "Gerasimova", 200);
        Smartphone smartphone1 = new Smartphone(6, "LG", 15000, "LgCorporation");
        Book book3 = new Book(6, "My world", "Corovina", 1800);
       ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book3);

        Product[] actual = manager.searchBy("LG");
        Smartphone[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }


}
