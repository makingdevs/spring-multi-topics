package com.makingdevs.config

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.Database
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.support.AbstractPlatformTransactionManager

import javax.sql.DataSource

/**
 * Created by makingdevs on 11/25/16.
 */
@Configuration
@EnableJpaRepositories("com.makingdevs.repositories")
class AppConfig {

  @Bean
  ConfigObject configuration(){
    def path = "${System.properties['user.home']}/configuration.groovy"
    File file = new File(path)
    if(!file.exists())
      throw new RuntimeException("""
          The configuration file doesn't exist,
          please check the Wiki to copy and setup your environent""")
    new ConfigSlurper().parse(file.toURI().toURL())
  }

  @Bean
  @TypeChecked(TypeCheckingMode.SKIP)
  DataSource dataSource() {
    def config = configuration().dataSource
    new DriverManagerDataSource(
        url: config.url,
        driverClassName: config.driverClassName,
        username: config.username,
        password: config.password)
  }

  @Bean
  JpaVendorAdapter jpaVendorAdapter(){
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter()
    adapter.with {
      database = Database.MYSQL
      generateDdl = false
    }
    adapter
  }

  @Bean
  LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean()
    em.dataSource = dataSource()
    em.jpaVendorAdapter = jpaVendorAdapter()
    em.packagesToScan = ["com.makingdevs.model"]
    em
  }

  @Bean(name = "transactionManager")
  AbstractPlatformTransactionManager transactionManager(){
    new JpaTransactionManager(entityManagerFactory().object)
  }
}
