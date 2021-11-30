package com.oracle.poc.demomuiltipledatabase.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.oracle.poc.demomuiltipledatabase.nssfdb.repo",
                      entityManagerFactoryRef = "nssfdbEntityManager",
                      transactionManagerRef = "nssfdbTransactionManager")
public class NssfDbConfig {

    @Primary
    @Bean(name="nssfdbDataSource")
    @ConfigurationProperties(prefix="spring.datasource.database1")
    public DataSource nssfdbDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="nssfdbEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("nssfdbDataSource") DataSource dataSource){
        return builder
                .dataSource(dataSource)
                .packages("com.oracle.poc.demomuiltipledatabase.nssfdb.model")
                .persistenceUnit("database1")
                .build();
    }

    @Primary
    @Bean(name= "nssfdbTransactionManager")
    public PlatformTransactionManager nssfdbTransactionManager(
            @Qualifier("nssfdbEntityManager")EntityManagerFactory nssfdbEntityManagerFactory
            ){
        return new JpaTransactionManager(nssfdbEntityManagerFactory);
    }
}
