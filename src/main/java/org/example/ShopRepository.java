package org.example;

import org.exceptions.NotFoundException;

public class ShopRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    public void removeById(int id) {
        Product product = findById(id);
        if (product == null) {
            throw new NotFoundException("Element with id:" + id + "not found");
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        products = tmp;

    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
