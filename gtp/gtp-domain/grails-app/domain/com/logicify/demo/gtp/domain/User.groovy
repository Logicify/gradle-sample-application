package com.logicify.demo.gtp.domain

/**
 * Created by LOGICIFY\corvis on 10/16/14.
 */
class User {
    transient springSecurityService

    String username
    String password
    boolean enabled = true
    String email
    String firstName
    String lastName
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static transients = ['springSecurityService']

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }
}
