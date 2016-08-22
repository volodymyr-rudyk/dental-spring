package com.dental.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories("com.dental.persistence.repository")
@PropertySource(value = {"classpath:datasource.properties"})
//@Profile("one")
public class DaoConfig {

  @Autowired
  private Environment env;

  @Bean
  public DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    try {
      dataSource.setJdbcUrl(env.getRequiredProperty(DbConfig.DB_URL));
      dataSource.setUsername(env.getRequiredProperty(DbConfig.DB_USERNAME));
      dataSource.setPassword(env.getRequiredProperty(DbConfig.DB_PASSWORD));
      dataSource.setDriverClassName(env.getRequiredProperty(DbConfig.DB_DRIVER_CLASSNAME));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource());
    entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(DbConfig.PACKAGES_SCAN));
    entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
    entityManagerFactoryBean.setJpaProperties(hibernateProperties());
    return entityManagerFactoryBean;
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.valueOf(env.getRequiredProperty(DbConfig.DB_ENGINE)));
    adapter.setShowSql(env.getRequiredProperty(DbConfig.HIBERNATE_SHOW_SQL, Boolean.class));
    return adapter;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.id.new_generator_mappings", false);
    properties.put(DbConfig.HIBERNATE_JDBC_BATCH_SIZE, env.getProperty(DbConfig.HIBERNATE_JDBC_BATCH_SIZE));
    properties.put(DbConfig.HIBERNATE_DIALECT, env.getRequiredProperty(DbConfig.HIBERNATE_DIALECT));
    properties.put(DbConfig.HIBERNATE_SHOW_SQL, env.getRequiredProperty(DbConfig.HIBERNATE_SHOW_SQL));
    return properties;
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

  private interface DbConfig {
    String DB_DRIVER_CLASSNAME = "db.driverClassName";
    String DB_URL = "db.url";
    String DB_USERNAME = "db.username";
    String DB_PASSWORD = "db.password";
    String HIBERNATE_DIALECT = "db.hibernate.dialect";
    String HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    String HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
    String PACKAGES_SCAN = "packages.scan";
    String DB_ENGINE = "db.engine";
  }
}
