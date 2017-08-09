package ua.spring.app.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.spring.app.entity.Product;
import ua.spring.app.service.MyService;

public class DaoTest {
    public static void main(String[] args) {

        Product product = new Product();
        product.setName("phone");
        product.setManufacturer("apple");
        product.setDescription("7s");
        product.setPrice(20000);

      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/spring/applicationContext.xml");

        MyService myService = ((MyService) applicationContext.getBean("myService"));
        myService.delete(2);

    }
}
