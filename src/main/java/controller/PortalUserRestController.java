package controller;


import action.PortalUserService;
import entity.LoginData;
import entity.PortalUser;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.security.auth.login.LoginException;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.UUID;


@Path("/authentication")
@Stateless
public class PortalUserRestController {

    @EJB
    PortalUserService portalUserService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginData loginData) {
        try {
            authenticate(loginData.getName(), loginData.getPassword());
            NewCookie token = issueToken(loginData.getName());
            return Response.ok().cookie(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        if (!portalUserService.loadUserById(username).getPassword().equals(password)) {
            throw new LoginException("Password or Username incorrect");
        }
    }

    private NewCookie issueToken(String username) {
        String authToken = UUID.randomUUID().toString();
        portalUserService.updateToken(username, authToken);
        NewCookie newCookie = new NewCookie("x-auth-token", authToken, "/", "localhost", "", 30 * 60, false, false);
        return newCookie;
    }

    @POST
    @Path("/logout")
    public Response logout(String token) {
        PortalUser portalUser = portalUserService.loadUserByToken(token.replaceAll("\"", ""));
        portalUserService.updateToken(portalUser.getLogin(), "");
        return Response.ok().build();
    }
}
