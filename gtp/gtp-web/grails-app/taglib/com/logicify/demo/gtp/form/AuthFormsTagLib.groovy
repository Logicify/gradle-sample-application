package com.logicify.demo.gtp.form

import grails.plugin.springsecurity.SpringSecurityUtils

/**
 * Created by LOGICIFY\corvis on 10/22/14.
 */
class AuthFormsTagLib {
    static namespace = "frm"

    def signupForm = { attrs ->
        out << render(template: '/forms/auth/signup')
    }

    def loginForm = { attrs ->
        def config = SpringSecurityUtils.securityConfig

        out << render(
                template: '/forms/auth/login',
                model: [postUrl            : "${request.contextPath}${config.apf.filterProcessesUrl}",
                        rememberMeParameter: config.rememberMe.parameter]
        )
    }
}
