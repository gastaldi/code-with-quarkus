package org.acme;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }


    @Scheduled(every = "10s", identity = "my-recurring-job")
    void everyTenSeconds() {
        Log.info("Executing recurring job every 10 seconds");
    }
}
