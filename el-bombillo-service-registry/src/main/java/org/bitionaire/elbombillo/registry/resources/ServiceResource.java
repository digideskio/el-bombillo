package org.bitionaire.elbombillo.registry.resources;

import io.dropwizard.auth.Auth;
import org.bitionaire.elbombillo.registry.api.model.Service;
import org.bitionaire.elbombillo.registry.core.auth.ServiceRegistryCaller;
import org.bitionaire.elbombillo.registry.jdbi.ServiceDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServiceResource {

    private final ServiceDAO serviceDAO;

    public ServiceResource(final ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @GET
    public List<Service> services(@Auth final ServiceRegistryCaller caller, @QueryParam("name") final String serviceName) {
        return serviceDAO.findByName(serviceName);
    }

}
