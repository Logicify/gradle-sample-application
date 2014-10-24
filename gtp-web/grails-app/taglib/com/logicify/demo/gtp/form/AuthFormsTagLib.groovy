package com.logicify.demo.gtp.form

import com.logicify.demo.gtp.webdomain.SignupFormModel
import grails.plugin.springsecurity.SpringSecurityUtils

/**
 * Created by LOGICIFY\corvis on 10/22/14.
 */
class AuthFormsTagLib {
    static namespace = "frm"

    def loginForm = { attrs ->
        def config = SpringSecurityUtils.securityConfig

        out << render(
                template: '/forms/auth/login',
                model: [postUrl            : "${request.contextPath}${config.apf.filterProcessesUrl}",
                        rememberMeParameter: config.rememberMe.parameter]
        )
    }

    def signupForm = { attrs ->
        SignupFormModel model = attrs.model ?: new SignupFormModel()
        out << render(template: '/forms/auth/signup', model:[signupFormModel:model])
    }
}
