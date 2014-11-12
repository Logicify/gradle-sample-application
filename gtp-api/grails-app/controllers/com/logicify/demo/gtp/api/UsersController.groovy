package com.logicify.demo.gtp.api

import com.logicify.demo.gtp.api.common.BaseApiController
import com.logicify.demo.gtp.model.SignupRequest
import gtp.service.UserService

class UsersController extends BaseApiController {

    UserService userService;

    def allUsers() {
        respond entity(userService.getAllRegisteredUsers())
    }

    def signup(SignupRequest signupRequest) {
        respond entity(signupRequest)
    }

}
