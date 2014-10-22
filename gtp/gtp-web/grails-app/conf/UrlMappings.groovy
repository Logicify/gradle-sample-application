class UrlMappings {

	static mappings = {

        name home: "/" (controller: 'homePage')
        name twoColExamplePage: "/example2colpage"(view: 'exampleToCol')
        name devPage: "/dev/appInfo"(view:"/dev/appInfo")

        /*group '/auth', {
            '/login'(controller: 'auth', action: 'login')
        }*/

        '/auth'(controller: 'auth')

        "500"(view:'/dev/error')
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
	}
}
