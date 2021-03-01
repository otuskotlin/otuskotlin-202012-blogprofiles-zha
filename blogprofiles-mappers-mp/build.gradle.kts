plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(project(":blogprofiles-common-be"))
    implementation(project(":blogprofiles-transport-mp"))

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
