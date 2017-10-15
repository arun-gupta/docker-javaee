package org.javaee.samples.employees;

import io.prometheus.client.Counter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * @author Arun Gupta
 */
@Path("employees")
@ApplicationScoped
public class EmployeeEndpoint {

    static final Counter requests_get_all = Counter.build()
            .name("requests_get_all").help("Total GET / requests.").register();
    static final Counter requests_get_one = Counter.build()
            .name("requests_get_one").help("Total GET /{id} requests.").register();

    @PersistenceContext
    EntityManager em;
    
    @GET
    @Produces({"application/xml", "application/json"})
    public Employee[] get() {
        requests_get_all.inc();
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList().toArray(new Employee[0]);
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Employee get(@PathParam("id") int id) {
        requests_get_one.inc();
        return em
                .createNamedQuery("Employee.findById", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
