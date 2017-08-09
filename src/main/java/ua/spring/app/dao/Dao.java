package ua.spring.app.dao;

import ua.spring.app.entity.Product;

import java.util.List;

public interface Dao {

    void create(Product product);

    Product read(int id);

    void update(Product product);

    void delete(int id);

    List<Product> readAllProduct();
}
