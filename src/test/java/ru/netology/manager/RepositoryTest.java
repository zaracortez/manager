package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    ProductRepository repo = new ProductRepository();
    Book book1 = new Book(10, "About dogs", "Gerasimova", 1500);
    Book book2 = new Book(3, "My world", "Corovina", 800);
    Book book3 = new Book(7, "Owl", "Nekrasov", 650);
    Smartphone smartphone1 = new Smartphone(12, "iPhone14", 150000, "Apple");
    Smartphone smartphone2 = new Smartphone(8, "SamsungA10", 40000, "LLC Samsung");
    Smartphone smartphone3 = new Smartphone(5, "XiaomiRedmi10", 35000, "Xiaomi");

    @Test
    public void shouldAddedProducts() {
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(book3);
        Product[] expected = {book2, smartphone1, book3};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveId() {
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(book2);
        repo.removeId(3);
        Product[] expected = {book3, smartphone1};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveProducts() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book3);
        Product[] expected = {book1, smartphone1, book3};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemovePrice() {
        repo.add(book3);
        repo.add(smartphone3);
        repo.add(book2);
        repo.removePrice(650);
        Product[] expected = {smartphone3, book2};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

}