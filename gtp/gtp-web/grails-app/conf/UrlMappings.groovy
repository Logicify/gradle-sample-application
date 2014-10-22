class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        name home: "/" (controller: 'homePage')

        name twoColExamplePage: "/example2colpage"(view: 'exampleToCol')
        name devPage: "/dev/appInfo"(view:"/dev/appInfo")
        "500"(view:'/dev/error')
	}
}
