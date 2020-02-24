package idv.hank.dropwizard.metrics.example.resources;

import com.google.inject.Inject;
import idv.hank.dropwizard.metrics.example.model.Domain;
import idv.hank.dropwizard.metrics.example.service.DomainService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/domain")
public class DomainResource {

    @Inject
    private DomainService domainService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Domain> get() {
        return domainService.getAll();
    }
}
