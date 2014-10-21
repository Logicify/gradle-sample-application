import com.logicify.demo.gtp.domain.Book
import com.logicify.demo.gtp.domain.Role
import com.logicify.demo.gtp.domain.User
import com.logicify.demo.gtp.domain.UserRole

class BootStrap {

    def init = { servletContext ->
        // Sample users
        def sampleUserDetails = [
                'user': [ fullName: 'User 1', email: 'user1@mymail.com', password: 'demo'],
                'user2': [ fullName: 'User 2', email: 'user2@mymail.com', password: 'demo'],
                'admin': [ fullName: 'Admin User', email: 'adminuser@mymail.com', password: 'admin'],
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
                UserRole.create(user, userDetails.containsKey('isAdmin') && userDetails.isAdmin ? adminRole : userRole);
            }
        }
    }
    def destroy = {
    }
}
