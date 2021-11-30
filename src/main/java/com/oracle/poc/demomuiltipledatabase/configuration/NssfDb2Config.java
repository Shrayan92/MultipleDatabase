package com.oracle.poc.demomuiltipledatabase.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.oracle.poc.demomuiltipledatabase.nssfdb2.repo",
        entityManagerFactoryRef = "nssfdb2EntityManagerFactory",
        transactionManagerRef = "nssfdb2TransactionManager")
public class NssfDb2Config {


    @Bean(name="nssfdb2DataSource")
    @ConfigurationProperties(prefix="spring.datasource.database2")
    public DataSource nssfdb2DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="nssfdb2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("nssfdb2DataSource") DataSource dataSource){
        return builder
                .dataSource(dataSource)
                .packages("com.oracle.poc.demomuiltipledatabase.nssfdb2.model")
                .persistenceUnit("database2")
                .build();
    }

    @Bean(name= "nssfdb2TransactionManager")
    public PlatformTransactionManager nssfdb2TransactionManager(
            @Qualifier("nssfdb2EntityManagerFactory")EntityManagerFactory nssfdb2EntityManagerFactory
    ){
        return new JpaTransactionManager(nssfdb2EntityManagerFactory);
    }
}
