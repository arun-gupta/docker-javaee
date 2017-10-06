package org.javaee.samples.employees;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.DatasourcesFraction;

public class Main {
    public static void main(String[] args) throws Exception {
        Container container = new Container();

        container.fraction(new DatasourcesFraction().jdbcDriver("com.mysql", (d) -> {
            d.driverClassName("com.mysql.jdbc.Driver");
            d.xaDatasourceClass("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
            d.driverModuleName("com.mysql");
        }).dataSource("MySQLDS", (ds) -> {
            ds.driverName("com.mysql");
            ds.connectionUrl(System.getenv().getOrDefault("JDBC_URL", "jdbc:mysql://mysql:3306/guestbook?useSSL=false&autoReconnect=true"));
            ds.userName(System.getenv().getOrDefault("DATASOURCE_USERNAME", "myuser"));
            ds.password(System.getenv().getOrDefault("DATASOURCE_PASSWORD", "mypassword"));
            ds.backgroundValidation(true);
            ds.validConnectionCheckerClassName("org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker");
            ds.validateOnMatch(true);
            ds.checkValidConnectionSql("SELECT 1");
        }));

        // Start the container and deploy the default war
        container.start().deploy();
    }
}
