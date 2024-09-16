package com.buskart.search.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class for JPA repositories.
 */
@Configuration
@EnableJpaRepositories(
    basePackages = "com.buskart.search.repository.jpa",
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager"
)
@EnableTransactionManagement
public class JpaConfig {
    // Define JPA-specific beans if necessary
}
