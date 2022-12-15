package ru.netology.manager;

public class Smartphone extends Product {

    protected String name;
    protected String producer;

    public Smartphone (int id, String name, int price, String producer) {

        super(id, name, price);

        this.name = name;
        this.producer = producer;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
