import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    application
    kotlin("jvm") version "1.4.31"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
    maven("./maven")
}

lateinit var implementationAppending: Configuration

configurations {
    register("implementationAppending") {
        implementationAppending = this
        configurations.implementation.get().extendsFrom(this)
    }
}

dependencies {
    implementation("junit:junit:4.13.2")
    implementationAppending(kotlin("stdlib-jdk8", "1.4.31"))
}

(tasks["shadowJar"] as ShadowJar).run {
    configurations = listOf(implementationAppending)
}

application {
    mainClass.set("dummy")
}
