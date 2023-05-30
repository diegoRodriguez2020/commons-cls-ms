/*
package com.bolivar.commons.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.sql.Connection;

@Configuration
@Slf4j
public class DatabaseConfiguration {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:postgresql://database-cls-paramters-local.ca6h8s3xeq3e.us-east-1.rds.amazonaws.com:5432/database-cls-paramters-local?user=postgres&password=administradorcls");
        //config.setUsername("postgres");
        //config.setPassword("administradorcls");
        ds = new HikariDataSource( config );
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}

 */