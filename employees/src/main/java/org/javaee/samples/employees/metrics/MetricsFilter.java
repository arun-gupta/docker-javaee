package org.javaee.samples.employees.metrics;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import static org.javaee.samples.employees.MyApplication.APP_ROOT;

/**
 * A servlet filter that gathers time to process each request.
 *
 * This filter is unaware if two requests are to be routed to the same JAX-RS route,
 * so requests to /employees/1 and /employees/2 will end up generating separate metrics.
 *
 * @author Michael Irwin
 */
@WebFilter(
    filterName = "metrics-filter",
    urlPatterns = APP_ROOT + "/*",
    initParams = {
        @WebInitParam(name = "metric-name", value = "app_metrics"),
        @WebInitParam(name = "path-components", value = "0")
    }
)
public class MetricsFilter extends io.prometheus.client.filter.MetricsFilter {

}
