package com.logicify.demo.gtp.webdomain

import com.logicify.demo.gtp.domain.User
import grails.validation.Validateable

/**
 * Created by LOGICIFY\corvis on 10/23/14.
 */
@Validateable
class SignupFormModel implements Serializable {
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
