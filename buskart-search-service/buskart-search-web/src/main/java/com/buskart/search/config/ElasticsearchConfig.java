package com.buskart.search.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Configuration class for Elasticsearch repositories.
 */
@Configuration
@EnableElasticsearchRepositories(
    basePackages = "com.buskart.search.repository.elasticsearch"
)
public class ElasticsearchConfig {
    // Define Elasticsearch-specific beans if necessary
}
