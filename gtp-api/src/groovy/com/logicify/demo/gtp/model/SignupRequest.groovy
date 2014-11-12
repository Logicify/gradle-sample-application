package com.logicify.demo.gtp.model

import com.logicify.demo.gtp.domain.User
import grails.validation.Validateable

/**
 * Created by LOGICIFY\corvis on 10/31/14.
 */
@Validateable
class SignupRequest {
    def username;
    def password;
    def repeatPassword;

    static constraints = {
        importFrom User
        repeatPassword validator: {val, obj, errors ->
            if (val != obj.password) errors.rejectValue('repeatPassword', 'noMatch')
        }
    }
}
