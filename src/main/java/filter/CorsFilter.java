package filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

import static javax.ws.rs.HttpMethod.*;

@Provider
@PreMatching
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add(
                "Access-Control-Allow-Origin", "http://localhost:4200");
        responseContext.getHeaders().add(
                "Access-Control-Allow-Credentials", true);
        responseContext.getHeaders().add(
                "Access-Control-Allow-Headers",
                "Origin, Content-type, Accept, Authorization, x-auth-token");
        responseContext.getHeaders().add(
                "Access-Control-Allow-Methods", DELETE + "," + POST + "," + GET + "," + PUT + "," + OPTIONS + "," + HEAD);
    }
}
