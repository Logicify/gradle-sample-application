package com.logicify.demo.gtp.api.common

class ErrorController extends BaseApiController {

    def internalServerErrorAction() {
        respond internalServerError()
    }

}
