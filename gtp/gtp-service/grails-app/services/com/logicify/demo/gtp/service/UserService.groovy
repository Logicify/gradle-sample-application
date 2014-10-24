package com.logicify.demo.gtp.service

import com.logicify.demo.gtp.domain.User
import grails.util.Holders

/**
 * Created by LOGICIFY\corvis on 10/24/14.
 */
class UserService {

    def getAllRegisteredUsers () {
        return User.findAll()
    }

    Integer getAllRegisteredUsersCount () {
        return User.count()
    }
}
