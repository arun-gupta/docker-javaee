package org.javaee.samples.employees;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import static org.javaee.samples.employees.MyApplication.APP_ROOT;

/**
 * @author arungupta
 */
@ApplicationPath(APP_ROOT)
public class MyApplication extends Application {

  public static final String APP_ROOT = "/resources";
    
}
