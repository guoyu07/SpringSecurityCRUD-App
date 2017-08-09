package ua.spring.app.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.spring.app.entity.Product;

import java.util.List;

@Repository
public class DaoImpl implements Dao {

    @Autowired
    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Product product) {
        Session session = sessionFactory.openSession();

        session.save(product);

    }

    public Product read(int id) {
        Session session = sessionFactory.openSession();
        return session.get(Product.class,id);
    }

    public void update(Product product) {

    }

    public void delete(int id) {

        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }
//        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Product> readAllProduct() {

        Session session = sessionFactory.openSession();

        return (List<Product>) session.createQuery("from Product").list();
    }
}
