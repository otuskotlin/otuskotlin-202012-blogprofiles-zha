rootProject.name = "202012-blogprofiles-zha"

pluginManagement {
    val kotlinVersion: String by settings

    val springDependencyVersion: String by settings
    val springBootVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("jvm") version kotlinVersion apply false
        kotlin("js") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false

        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyVersion
    }
}

include("blogprofiles-common-be")
include("blogprofiles-common-mp")
include("blogprofiles-transport-mp")
include(":blogprofiles-transport-mp")
include("blogprofiles-mappers-mp")
include("blogprofiles-be-app-spring")
