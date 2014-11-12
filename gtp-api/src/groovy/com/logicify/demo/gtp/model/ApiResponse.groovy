package com.logicify.demo.gtp.model

/**
 * Created by LOGICIFY\corvis on 10/27/14.
 */
class ApiResponse {
    // Constants
    static final int CODE_SUCCESSFUL = 0;
    static final int CODE_NOT_FOUND = 404;
    static final int CODE_SERVER_ERROR = 500;

    private static final def SUCCESSFUL_RESPONSES = 200..<300;

    // Properties
    int statusCode;
    String statusMessage;

    Date requestStart;
    Date requestEnd;
    Object data = null;

    boolean isSuccessful() {
        return SUCCESSFUL_RESPONSES.contains(statusCode)
    }

    Long getRequestDuration() {
        (requestStart && requestEnd) ? requestEnd.getTime() - requestStart.getTime() : null;
    }

    @Override
    void setProperty(String property, Object newValue) {
        if (requestEnd && statusCode != CODE_SERVER_ERROR) {
            throw new IllegalStateException('ApiResponse is already closed (responseEnd defined).')
        }
        getMetaClass().setProperty(this, property, newValue)
    }
}
