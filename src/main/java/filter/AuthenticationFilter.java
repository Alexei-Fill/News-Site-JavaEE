package filter;

import action.PortalUserService;
import security.CustomSecured;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.security.enterprise.AuthenticationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

import static javax.ws.rs.Priorities.AUTHENTICATION;

@CustomSecured
@Provider
@Priority(AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @EJB
    PortalUserService portalUserService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Cookie authCookie = requestContext.getCookies().get("x-auth-token");
        if (authCookie == null) {
            abortWithUnauthorized(requestContext);
            return;
        }
        String token = authCookie.getValue();
        try {
            validateToken(token);
        } catch (Exception e) {
            abortWithUnauthorized(requestContext);
        }
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
    }

    private void validateToken(String token) throws Exception {
        System.out.println(portalUserService.loadUserByToken(token).toString());
        if (portalUserService.loadUserByToken(token) == null) {
            throw new AuthenticationException("Token is not valid");
        }
    }
}
