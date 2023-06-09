package com.example.spring_boot_templete.common;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.spring_boot_templete.repository"})
@EnableJpaAuditing
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Value("${spring.datasource.driverClassName}")
    private String DriverClassName;

    @Value("${spring.datasource.url.read-write}")
    private String ReadWriteUrl;

    @Value("${spring.datasource.url.read-only}")
    private String ReadOnlyUrl;

    @Value("${spring.datasource.username}")
    private String UserName;

    @Value("${spring.datasource.password}")
    private String Password;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int MaximumPoolSize;

    @Value("${spring.datasource.hikari.auto-commit}")
    private boolean AutoCommit;

    @Bean(name = "readWriteDataSource")
    public DataSource readWriteDataSource() {
        return this.buildDataSource(
                DriverClassName,
                ReadWriteUrl,
                UserName,
                Password,
                "read-write",
                MaximumPoolSize,
                AutoCommit
        );
    }

    @Bean(name = "readOnlyDataSource")
    public DataSource readOnlyDataSource() {
        return this.buildDataSource(
                DriverClassName,
                ReadOnlyUrl,
                UserName,
                Password,
                "read-only",
                MaximumPoolSize,
                AutoCommit
        );
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource(
            @Qualifier("readWriteDataSource") DataSource readWriteDataSource,
            @Qualifier("readOnlyDataSource") DataSource readOnlyDataSource) {

        return new LazyReplicationConnectionDataSourceProxy(readWriteDataSource, readOnlyDataSource);
    }

    private DataSource buildDataSource(
            String driverClassName,
            String url,
            String userName,
            String password,
            String poolName,
            int maximumPoolSize,
            boolean autoCommit
    ) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(url);
        config.setUsername(userName);
        config.setPassword(password);
        config.setPoolName(poolName);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setAutoCommit(autoCommit);
        return new HikariDataSource(config);
    }

}
