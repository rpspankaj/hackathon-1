package com.jersey.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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
	@Autowired
	 private Environment env;
	 

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String dbType= env.getProperty("db.type");
		if (dbType.equals("postgres")) {
			dataSource.setDriverClassName(env.getProperty("db.postgres.driver"));
			dataSource.setUrl(env.getProperty("db.postgres.url"));
			dataSource.setUsername(env.getProperty("db.postgres.username"));
			dataSource.setPassword(env.getProperty("db.postgres.password"));
		}
		else{
			dataSource.setDriverClassName(env.getProperty("db.sqllite.driver"));
			dataSource.setUrl(env.getProperty("db.sqllite.url"));
			dataSource.setUsername(env.getProperty("db.sqllite.username"));
			dataSource.setPassword(env.getProperty("db.sqllite.password"));
			
		}
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
        String dbType= env.getProperty("db.type");
		if (dbType.equals("postgres")) {
			hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.postgres.dialect"));
		}
		else{
			hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.sqllite.dialect"));
		}
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.use_sql_comments", "false");
        hibernateProperties.setProperty("hibernate.format_sql", "false");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

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
