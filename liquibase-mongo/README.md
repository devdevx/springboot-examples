# Steps to add Liquibase to a Spring Boot MongoDB project
- Add the `liquibase-core` and `liquibase-mongodb` dependencies to `pom.xml`
- Set liquibase dependencies to `4.x`
- Use a MongoDB minimum version of `3.6.x`
- Disable the `LiquibaseAutoConfiguration`
- Define a runner to execute the `MongoLiquibaseDatabase` programmatically using the Spring Boot properties