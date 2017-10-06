package org.javaee.samples.employees;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.DatasourcesFraction;

public class Main {
    public static void main(String[] args) throws Exception {
        Container container = new Container();

        container.fraction(new DatasourcesFraction().jdbcDriver("com.mysql").dataSource("ExampleDS"));

        // Start the container and deploy the default war
        container.start().deploy();
    }
}
