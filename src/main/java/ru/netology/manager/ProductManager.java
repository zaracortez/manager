package ru.netology.manager;

public class ProductManager {

    ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.add(product);
    }

    public Product[] findAll() {
        //return repo.findAll(); мой вариант
        return repo.getProducts();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        //for (Product product : repo.findAll()) {мой вариант
        for (Product product : repo.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}
