package idv.hank.dropwizard.metrics.example.resources;

import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HelloResource {

    @GET
    public String sayHello() {
        return String.format("Hello World UTC:%s", new Date());
    }
}
