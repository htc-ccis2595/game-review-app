package edu.htc.gamedata.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"edu.htc.gamedata.entities"})
@EnableJpaRepositories(basePackages = {"edu.htc.gamedata.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {

    // Configuration done through annotations above.

}
