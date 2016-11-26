package com.OviWebApplication.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by Ovi on 11/20/2016.
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.OviWebApplication.domain"})
@EnableJpaRepositories(basePackages = {"com.OviWebApplication.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
