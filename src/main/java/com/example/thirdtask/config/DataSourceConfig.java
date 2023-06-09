package com.example.thirdtask.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean
    public DataSource getDataSource(){
        DataSource dataSource = null;
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5438/postgres");
        builder.username("postgres");
        builder.password("qwerty");
        builder.driverClassName("org.postgresql.Driver");
        dataSource = builder.build();
        return dataSource;



    }
}
