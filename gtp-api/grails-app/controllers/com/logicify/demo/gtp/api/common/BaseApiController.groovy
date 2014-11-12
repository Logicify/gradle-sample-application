package com.logicify.demo.gtp.api.common

import com.logicify.demo.gtp.model.ApiResponse
import grails.artefact.Artefact
import static org.springframework.http.HttpStatus.*

/**
 * Created by LOGICIFY\corvis on 10/29/14.
 */
@Artefact("Controller")
class BaseApiController {
    static responseFormats = ['json', 'xml']
    static scope = "prototype"

    protected ApiResponse apiResponse;

    def beforeInterceptor = {
        delegate.apiResponse = delegate.getApiResponse()
        return true
    }

    protected ApiResponse getApiResponse() {
        if (!apiResponse) {
            apiResponse = new ApiResponse(statusCode: OK.value(), requestStart: new Date())
        }
        return apiResponse
    }

    protected def notFound(message=null) {
        submitApiResponse(ApiResponse.CODE_NOT_FOUND, object, message ?: 'Not found')
    }

    protected def internalServerError(message=null) {
        submitApiResponse(ApiResponse.CODE_SERVER_ERROR, object, message ?: 'Internal server error')
    }

    protected def created(object=null, message=null) {
        submitApiResponse(CREATED.value(), object, message ?: 'Successfully added')
    }

    protected def entity(object=null, message=null) {
        submitApiResponse(OK.value(), object, message)
    }

    private ApiResponse submitApiResponse(status=null, object = null, message='') {
        getApiResponse().with {
            statusCode = status
            statusMessage = message
            data = object
            requestEnd = new Date()
            return it
        }
    }
}