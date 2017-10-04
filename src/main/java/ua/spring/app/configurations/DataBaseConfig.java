package ua.spring.app.configurations;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan({"ua.spring.app.dao","ua.spring.app.service"})
@PropertySource("database.properties")
@EnableTransactionManagement
public class DataBaseConfig {

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.userName}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driverClass}")
    private String driverClassname;
    @Value("${jdbc.dialect}")
    private String dialect;
    @Value("${hibernate.show_sql}")
    private String showSql;
    @Value("${hibernate.format_sql}")
    private String formatSql;
//    @Value("${hibernate.hbm2ddl.auto}")
//    private String hbm2ddlAuto;
//    @Value("${hibernate.enable_lazy_load_no_trans}")
//    private String enableLazyLoadOnTrans;
//    @Value("${current_session_context_class}")
//    private String current_session_context_class;
    @Value("${hibernate.connection.charSet}")
    private String charSet;
    @Value("${connection.characterEncoding}")
    private String characterEncoding;



    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassname);
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
//        properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
//        properties.put("hibernate.enable_lazy_load_no_trans", enableLazyLoadOnTrans);
//        properties.put("current_session_context_class", current_session_context_class);
        properties.put("hibernate.connection.charSet", charSet);
        properties.put("connection.characterEncoding", characterEncoding);
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setHibernateProperties(hibernateProperties());
        bean.setPackagesToScan("ua.spring.app.entity");
        return bean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}
