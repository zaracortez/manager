package ru.netology.manager;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void add(Product product) {

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;

    }

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    public void removeId(int id) {
        Product[] tmp = new Product[products.length - 1];
        int IndexToInsert = 0;
        for (Product product : products)
            if (product.getId() != id) {
                tmp[IndexToInsert] = product;
                IndexToInsert++;
            }
        products = tmp;

    }



    public Product[] getProducts() {
        return products;
    }


    public void removePrice(int price) {
        Product[] tmp = new Product[products.length - 1];
        int IndexToInsert = 0;
        for (Product product : products)
            if (product.getPrice() != price) {
                tmp[IndexToInsert] = product;
                IndexToInsert++;
            }
        products = tmp;

    }
    public Product[] findAll() {

        return products;
    }
}

