package org.javaee.samples.employees.metrics;

import io.prometheus.client.hotspot.DefaultExports;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * A {@link ServletContextListener} that enables default metric gathering.
 *
 * @author Michael Irwin
 */
@WebListener
public class MetricsInitializer implements ServletContextListener {


  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    DefaultExports.initialize();
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    // Nothing to do
  }
}
