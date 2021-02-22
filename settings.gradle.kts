rootProject.name = "202012-blogprofiles-zha"

pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("js") version kotlinVersion
    }
}

include("blogprofiles-common-be")
include("blogprofiles-common-mp")
