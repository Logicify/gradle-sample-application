class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: 'homePage')
        "/dev/appInfo"(view:"/dev/appInfo")
        "500"(view:'/error')
	}
}
