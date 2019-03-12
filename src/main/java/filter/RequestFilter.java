//package filter;
//
//import security.CustomAuthenticator;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.Response;
//import java.io.IOException;
//
//public class RequestFilter implements ContainerRequestFilter {
//    @Override
//    public void filter(ContainerRequestContext requestCtx) throws IOException {
//        String path = requestCtx.getUriInfo().getPath();
//
//        // IMPORTANT!!! First, Acknowledge any pre-flight test from browsers for this case before validating the headers (CORS stuff)
//        if ( requestCtx.getRequest().getMethod().equals( "OPTIONS" ) ) {
//            requestCtx.abortWith( Response.status( Response.Status.OK ).build() );
//            return;
//        }
//
//        // Then check is the service key exists and is valid.
//        CustomAuthenticator demoAuthenticator = CustomAuthenticator.getInstance();
////        String serviceKey = requestCtx.getHeaderString( DemoHTTPHeaderNames.SERVICE_KEY );
////
////        if ( !demoAuthenticator.isServiceKeyValid( serviceKey ) ) {
////            // Kick anyone without a valid service key
////            requestCtx.abortWith( Response.status( Response.Status.UNAUTHORIZED ).build() );
////
////            return;
////        }
//
//        // For any pther methods besides login, the authToken must be verified
//        if ( !path.startsWith( "/log/" ) ) {
//            String authToken = requestCtx.getHeaderString( "x-auth-token" );
//
//            // if it isn't valid, just kick them out.
//            if ( !demoAuthenticator.isAuthTokenValid(authToken ) ) {
//                requestCtx.abortWith( Response.status( Response.Status.UNAUTHORIZED ).build() );
//            }
//        }
//    }
//}
