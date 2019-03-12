//package security;
//
//import action.PortalUserService;
//import entity.PortalUser;
//
//import javax.ejb.EJB;
//import javax.security.auth.login.LoginException;
//import java.security.GeneralSecurityException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//public class CustomAuthenticator {
//
//    @EJB
//    PortalUserService portalUserService;
//    private static CustomAuthenticator authenticator = null;
////    private final Map<String, String> authorizationTokensStorage = new HashMap();
//
//    private CustomAuthenticator() { }
//
//    public static CustomAuthenticator getInstance() {
//        if ( authenticator == null ) {
//            authenticator = new CustomAuthenticator();
//        }
//        return authenticator;
//    }
//
//    public String login( String username, String password ) throws LoginException {
//        PortalUser portalUser = portalUserService.loadUserById(username);
//        if ((portalUser != null) && (portalUser.getPassword().equals(password))) {
//            String authToken = UUID.randomUUID().toString();
//            portalUserService.updateToken(username, authToken);
////            authorizationTokensStorage.put( authToken, username );
//            return authToken;
//        }
//        throw new LoginException( "Username or Password incorrect" );
//    }
//
//    public boolean isAuthTokenValid(String authToken ) {
//        PortalUser portalUser = portalUserService.loadUserByToken(authToken);
//        if (portalUser != null) {
//            return true;
//        }
//        return false;
//    }
//
//       public void logout(String authToken ) throws GeneralSecurityException {
//        portalUserService.remove( authToken );
//        return;
//    }
//}
