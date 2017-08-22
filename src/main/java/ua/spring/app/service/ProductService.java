package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.spring.app.dao.ProductDao;
import ua.spring.app.entity.Product;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao prodDao;


    @Transactional
    public void create(Product product) {
        prodDao.create(product);
    }

    @Transactional(readOnly = true)
    public Product read(int id) {
        return prodDao.read(id);
    }


    @Transactional
    public void update(Product product) {
        prodDao.update(product);
    }

    @Transactional
    public void delete(int id) {
        prodDao.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return prodDao.readAllProduct();
    }
}
