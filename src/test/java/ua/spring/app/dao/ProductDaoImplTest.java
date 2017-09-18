package ua.spring.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.spring.app.entity.Product;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DaoConfiguration.class)
public class ProductDaoImplTest {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private ProductDao productDao;
    private Product product;


    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        product = mock(Product.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        productDao = new ProductDaoImpl(sessionFactory);
    }

    @Test
    public void create() throws Exception {
        doAnswer(invocation -> {
            String name = invocation.getMethod().getName();
            assertEquals(name,"save");
        return null;
        }).when(session).save(product);

        productDao.create(product);

        verify(session, atLeastOnce()).save(product);

    }

    @Test
    public void read() throws Exception {
        when(product.getName()).thenReturn("Ogirok");
        when(session.get(Product.class, 1)).thenReturn(product);

        assertEquals(product, productDao.read(1));
        verify(session, times(1)).get(Product.class, 1);
        assertEquals("Ogirok", product.getName());
    }

    @Test
    public void update() throws Exception {
        doAnswer(invocation -> null).when(session).update(product);

        productDao.update(product);

        verify(session,times(1)).update(product);
    }

    @Test
    public void delete() throws Exception {
        doAnswer(invocation -> null).when(session).delete(product);
        when(session.get(Product.class, 1)).thenReturn(product);
        productDao.delete(1);

        assertEquals(product, session.get(Product.class,1));
        verify(session, atLeastOnce()).get(Product.class,1);
        verify(session, atLeastOnce()).delete(product);
    }

    @Test
    public void readAllProduct() throws Exception {
        Query query = mock(Query.class);
        List list = mock(List.class);

        when(session.createQuery("from Product")).thenReturn(query);
        when(query.list()).thenReturn(list);
        when(list.get(0)).thenReturn(product);
        when(product.getName()).thenReturn("Pomidor");

        assertEquals(list, productDao.readAllProduct());
        assertEquals(product, list.get(0));
        assertFalse(list.isEmpty());

        verify(query, times(1)).list();
        verify(session, atLeastOnce()).createQuery("from Product");
    }

}