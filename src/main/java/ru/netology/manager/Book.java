package ru.netology.manager;

public class Book extends Product {
    protected String name;
    protected String author;

    public Book(int id, String name, String author, int price) {

        super(id, name, price);

        this.author = author;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

