import com.logicify.demo.gtp.domain.Role
import com.logicify.demo.gtp.domain.User
import com.logicify.demo.gtp.domain.UserRole

class BootStrap {

    def init = { servletContext ->
        // Sample users
        def sampleUserDetails = [
                'user': [ fullName: 'User 1', email: 'user1@mymail.com', password: 'demo', isAdmin: false],
                'user2': [ fullName: 'User 2', email: 'user2@mymail.com', password: 'demo', isAdmin: false],
                'admin': [ fullName: 'Admin User', email: 'adminuser@mymail.com', password: 'admin', isAdmin: true],
        ]
        // Creating roles if needed
        def userRole = Role.findByAuthority(Role.ROLE_USER) ?: new Role(authority: Role.ROLE_USER).save(flash: true);
        def adminRole = Role.findByAuthority(Role.ROLE_ADMIN) ?: new Role(authority: Role.ROLE_ADMIN).save(flash: true);
        if (!User.count()) {
            sampleUserDetails.each {username, userDetails ->
                def user = new User(username: username,
                        password: userDetails.password,
                        accountExpired: false,
                        accountLocked: false,
                        enabled: true,
                )
                if (user.validate()) {
                    println("Creating sample user: ${user.username} with password ${user.password}")
                    user.save()
                }
                // Assign role
                UserRole.create(user, userDetails.isAdmin ? adminRole : userRole);
            }
        }
    }
    def destroy = {
    }
}
