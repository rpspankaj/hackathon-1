package com.jersey.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.SpringSessionContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
@Configuration
@EnableJpaRepositories(basePackages = "com.walmart.hackathon.persistence")
public class SqlInitialization{

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://ec2-54-243-200-159.compute-1.amazonaws.com:5432/dakf58su6kvi5p?sslmode=require");
        dataSource.setUsername("psjfszkjnbhpiv");
        dataSource.setPassword("AgfkslcEamdxpREzfO-Zto5esP");
       
        return dataSource;
    }

    @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("com.walmart.hackathon.model");
        entityManagerFactoryBean.setJpaProperties(buildHibernateProperties());
        entityManagerFactoryBean.setJpaProperties(new Properties() {{
            put("hibernate.current_session_context_class", SpringSessionContext.class.getName());
        }});
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter() {{
            setDatabase(Database.POSTGRESQL);
        }});
        return entityManagerFactoryBean;
    }

    protected Properties buildHibernateProperties()
    {
        Properties hibernateProperties = new Properties();

        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.use_sql_comments", "false");
        hibernateProperties.setProperty("hibernate.format_sql", "false");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");

        hibernateProperties.setProperty("hibernate.generate_statistics", "false");

        hibernateProperties.setProperty("javax.persistence.validation.mode", "none");

        //Audit History flags
        hibernateProperties.setProperty("org.hibernate.envers.store_data_at_delete", "true");
        hibernateProperties.setProperty("org.hibernate.envers.global_with_modified_flag", "true");

        return hibernateProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    @Bean
    public TransactionTemplate transactionTemplate() {
        return new TransactionTemplate(transactionManager());
    }
}
