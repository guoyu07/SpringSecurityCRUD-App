package ua.spring.app.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.spring.app.entity.Product;
import ua.spring.app.service.ProductService;


public class DaoTest {
    public static void main(String[] args) {

        Product product = new Product();
        product.setName("phone");
        product.setManufacturer("apple");
        product.setDescription("7s");
        product.setPrice(20000);

      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/spring/applicationContext.xml");

        ProductService productService = ((ProductService) applicationContext.getBean("productService"));
        productService.delete(2);
    }
}
