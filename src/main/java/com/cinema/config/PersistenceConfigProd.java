package com.cinema.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile("prod")
@PropertySource({"classpath:properties/persistence-prod.properties"})
public class PersistenceConfigProd extends PersistenceConfigGeneric {

  @Override
  @Bean
  public DataSource dataSource() {
    return super.dataSource();
  }

  @Override
  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    return super.sessionFactory();
  }

  @Override
  @Bean
  public HibernateTransactionManager transactionManager() {
    return super.transactionManager();
  }

  @Override
  @Value("${datasource.url}")
  public void setUrl(String url) {
    super.setUrl(url);
  }

  @Override
  @Value("${datasource.driver}")
  public void setDriver(String driver) {
    super.setDriver(driver);
  }

  @Override
  @Value("${datasource.username}")
  public void setUsername(String username) {
    super.setUsername(username);
  }

  @Override
  @Value("${datasource.password}")
  public void setPassword(String password) {
    super.setPassword(password);
  }

  @Override
  @Value("${datasource.pool-size}")
  public void setPoolSize(String poolSize) {
    super.setPoolSize(poolSize);
  }

  @Override
  @Value("${hibernate.show_sql}")
  public void setShowSql(String showSql) {
    super.setShowSql(showSql);
  }

  @Override
  @Value("${hibernate.hbm2ddl.auto}")
  public void setDdl(String ddl) {
    super.setDdl(ddl);
  }

  @Override
  @Value("${hibernate.dialect}")
  public void setDialect(String dialect) {
    super.setDialect(dialect);
  }
}
