package action.security;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@DatabaseIdentityStoreDefinition(
        callerQuery = "#{'select user_password from portal_user where user_login = ?'}",
        groupsQuery = "select role from portal_user where user_login = ?")

@ApplicationScoped
@Named
public class ApplicationConfig {
}
