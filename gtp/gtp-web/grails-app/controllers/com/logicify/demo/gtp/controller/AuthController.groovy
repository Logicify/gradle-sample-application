package com.logicify.demo.gtp.controller

import com.logicify.demo.gtp.webdomain.SignupFormModel
import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.access.annotation.Secured
import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.web.WebAttributes
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletResponse

/**
 * Created by LOGICIFY\corvis on 10/22/14.
 */
class AuthController {

    def springSecurityService

    def login() {
        render view: '/login'
    }

    def logout() {
        // TODO put any pre-logout code here
        redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl
    }

    def signup() {
        if (!request.post) {
            return render(view: '/signup')
        } else {
            SignupFormModel signupFormModel = new SignupFormModel()
            bindData(signupFormModel, params)
            if (!signupFormModel.validate()) {
                return render(view: '/signup', model:[signupFormModel: signupFormModel])
            } else {
                return render('VALIDATED!')
            }
        }
    }

    /**
     * Callback after a failed login. Redirects to the auth page with a warning message.
     */
    def loginfailed() {
        String msg = ''
        def exception = session[WebAttributes.AUTHENTICATION_EXCEPTION]
        if (exception) {
            if (exception instanceof AccountExpiredException) {
                msg = g.message(code: "springSecurity.errors.login.expired")
            }
            else if (exception instanceof CredentialsExpiredException) {
                msg = g.message(code: "springSecurity.errors.login.passwordExpired")
            }
            else if (exception instanceof DisabledException) {
                msg = g.message(code: "springSecurity.errors.login.disabled")
            }
            else if (exception instanceof LockedException) {
                msg = g.message(code: "springSecurity.errors.login.locked")
            }
            else {
                msg = g.message(code: "springSecurity.errors.login.fail")
            }
        }

        if (springSecurityService.isAjax(request)) {
            render([error: msg] as JSON)
        }
        else {
            flash.message = msg
            redirect action: 'login', params: params
        }
    }
}
