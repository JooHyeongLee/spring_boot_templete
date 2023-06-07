package com.example.spring_boot_templete.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class HealthCheck implements HealthIndicator {
    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.username}")
    private String databaseUsername;
    @Value("${spring.datasource.password}")
    private String databasePassword;

    @Override
    public Health health() {
        if (isMyServiceUp()) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("Service", "not available").build();
        }
    }

    private boolean isMyServiceUp() {
        // Database 연결상태 확인
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        try {
            dataSource.getConnection().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
