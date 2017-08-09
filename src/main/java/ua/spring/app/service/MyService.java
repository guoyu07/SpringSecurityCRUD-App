package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.spring.app.dao.Dao;
import ua.spring.app.entity.Product;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private Dao dao;


    @Transactional
    public void create(Product product) {
        dao.create(product);
    }

    @Transactional(readOnly = true)
    public Product read(int id) {
        return null;
    }


    @Transactional
    public void update(Product product) {

    }

    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return dao.readAllProduct();
    }
}
