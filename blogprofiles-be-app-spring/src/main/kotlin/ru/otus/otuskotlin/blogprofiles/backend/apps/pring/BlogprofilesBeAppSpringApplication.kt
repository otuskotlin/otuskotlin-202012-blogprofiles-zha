package ru.otus.otuskotlin.blogprofiles.backend.apps.pring

import org.springframework.fu.kofu.webApplication
import org.springframework.fu.kofu.webmvc.webMvc

val app = webApplication {
    beans {
        bean<BlogprofilesProfileService>()
    }

    webMvc {
        port = if (profiles.contains("test")) 8181 else 8080
        router {
            val handler = ref<BlogprofilesProfileService>()
            POST("/profile/list", handler::list)
            POST("/profile/create", handler::create)
            POST("/profile/read", handler::read)
            POST("/profile/update", handler::update)
            POST("/profile/delete", handler::delete)
        }
        converters {
            string()
            jackson()
        }
    }
}

fun main() {
    app.run()
}