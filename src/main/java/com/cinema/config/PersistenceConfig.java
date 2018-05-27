package com.cinema.config;

import com.cinema.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:properties/persistence-${spring.profiles.active:dev}.properties"})
public class PersistenceConfig {
  @Value("${datasource.url}")
  private String url;

  @Value("${datasource.driver}")
  private String driver;

  @Value("${datasource.username}")
  private String username;

  @Value("${datasource.password}")
  private String password;

  @Value("${datasource.pool-size}")
  private String poolSize;

  @Value("${hibernate.show_sql}")
  private String showSql;

  @Value("${hibernate.hbm2ddl.auto}")
  private String ddl;

  @Value("${hibernate.dialect}")
  private String dialect;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
    factoryBean.setDataSource(dataSource());
    Properties props=new Properties();
    props.put("hibernate.show_sql", showSql);
    props.put("hibernate.hbm2ddl.auto", ddl);
    props.put("hibernate.dialect", dialect);
    factoryBean.setHibernateProperties(props);
    factoryBean.setPackagesToScan("com.cinema.model");
    return factoryBean;
  }

  @Bean
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }
}
