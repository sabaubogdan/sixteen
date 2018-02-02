package xyz.vegaone.sixteen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SixteenConfig {

    private SpringProperties springProperties;

    @Autowired
    public SixteenConfig(SpringProperties springProperties) {
        this.springProperties = springProperties;
    }

    @Bean
    @LiquibaseDataSource
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username(springProperties.getDataSource().getUsername())
                .password(springProperties.getDataSource().getPassword())
                .url(springProperties.getDataSource().getJdbcUrl())
                .driverClassName(springProperties.getDataSource().getDriverClassName())
                .build();

    }
}
