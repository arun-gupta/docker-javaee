package org.javaee.samples.employees.metrics;

import javax.servlet.annotation.WebServlet;

/**
 * Register the Prometheus Metrics Servlet.
 *
 * @author Michael Irwin
 */
@WebServlet("/metrics")
public class MetricsServlet extends io.prometheus.client.exporter.MetricsServlet {

}
