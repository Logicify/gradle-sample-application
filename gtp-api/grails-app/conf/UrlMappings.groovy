class UrlMappings {

	static mappings = {
        group('/user') {
            '/all'(controller: 'users', action: 'allUsers', method: 'GET')
            '/signup'(controller: 'users', action: 'signup', method: 'POST')
        }

        "500"(controller: 'error', action: 'internalServerErrorAction')
	}
}
