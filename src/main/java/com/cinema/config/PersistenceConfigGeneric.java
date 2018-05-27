package com.cinema.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public abstract class PersistenceConfigGeneric {
  private String url;
  private String driver;
  private String username;
  private String password;
  private String poolSize;
  private String showSql;
  private String ddl;
  private String dialect;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPoolSize() {
    return poolSize;
  }

  public void setPoolSize(String poolSize) {
    this.poolSize = poolSize;
  }

  public String getShowSql() {
    return showSql;
  }

  public void setShowSql(String showSql) {
    this.showSql = showSql;
  }

  public String getDdl() {
    return ddl;
  }

  public void setDdl(String ddl) {
    this.ddl = ddl;
  }

  public String getDialect() {
    return dialect;
  }

  public void setDialect(String dialect) {
    this.dialect = dialect;
  }

  public  DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

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

  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }
}
