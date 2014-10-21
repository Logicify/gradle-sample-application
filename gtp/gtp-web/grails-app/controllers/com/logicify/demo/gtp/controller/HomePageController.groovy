package com.logicify.demo.gtp.controller

import org.springframework.security.access.annotation.Secured


/**
 * Created by LOGICIFY\corvis on 10/16/14.
 */
class HomePageController {
    @Secured('permitAll')
    def index() {
        render view: '/home'
    }
}
