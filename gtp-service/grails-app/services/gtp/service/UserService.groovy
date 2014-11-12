package gtp.service

import com.logicify.demo.gtp.domain.User
import grails.transaction.Transactional

@Transactional
class UserService {

    def getAllRegisteredUsers () {
        return User.findAll()
    }

    Integer getAllRegisteredUsersCount () {
        return User.count()
    }
}
