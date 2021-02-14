package com.devdevx.sb.examples.core;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.integration.spring.SpringResourceAccessor;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Import(LiquibaseProperties.class)
public class MongoLiquibaseRunner implements CommandLineRunner {

    private final MongoProperties mongoProperties;
    private final LiquibaseProperties liquibaseProperties;
    private final ResourceLoader resourceLoader;

    public void run(final String... args) throws Exception {
        MongoLiquibaseDatabase database = (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(mongoProperties.determineUri(), null, null, null, null);
        Liquibase liquiBase = new Liquibase(liquibaseProperties.getChangeLog(), new SpringResourceAccessor(resourceLoader), database);
        liquiBase.update("");
    }

}
