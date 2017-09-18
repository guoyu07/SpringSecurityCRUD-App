package ua.spring.app.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.spring.app.entity.Product;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Product product) {
        Session session = sessionFactory.getCurrentSession();

        session.save(product);

    }

    public Product read(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();

        session.update(product);
    }

    public void delete(int id) {

        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Product> readAllProduct() {

        Session session = sessionFactory.getCurrentSession();

        return (List<Product>) session.createQuery("from Product").list();
    }
}
