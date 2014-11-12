package com.logicify.demo.gtp.domain

import grails.persistence.Entity

@Entity
class Role {
    static ROLE_ADMIN = 'ROLE_ADMIN'
    static ROLE_USER = 'ROLE_USER'

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
