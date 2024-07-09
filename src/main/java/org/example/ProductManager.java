package org.example;

public class ProductManager {
    private ShopRepository repo;

    public ProductManager(ShopRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.add(product);
    }

   

    public Product[] searchBy(String text) {
        Product[] products = repo.findAll();
        Product[] result = new Product[0];
        for (Product product : products) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
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
