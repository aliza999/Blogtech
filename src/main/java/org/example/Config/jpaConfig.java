package org.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
@Configuration
public class jpaConfig {
    @Bean
    public EntityManagerFactory entityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean emfb=new LocalContainerEntityManagerFactoryBean();
        emfb.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        emfb.afterPropertiesSet(); //wil initialize the factory object
        return emfb.getObject();//will return enttymanagerfactory
    }
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource ds =new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5433/technicalblog");
        ds.setUsername("postgres");
        ds.setPassword("9814453900");
        return ds;
    }
}
