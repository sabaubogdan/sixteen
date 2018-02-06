package xyz.vegaone.sixteen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SixteenConfig {

    @Autowired
    private SpringProperties springProperties;

    @Bean
    @LiquibaseDataSource
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("sa")
                .password("")
                .url("jdbc:h2:mem:easytrack;DB_CLOSE_ON_EXIT=FALSE")
                .build();

    }
}