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

/*
buildscript {
    repositories {
        maven("./maven")
    }
}
*/
/*
plugins {
    application
    kotlin("jvm") version "1.4.31"
}

repositories {
    //maven("./maven")
    mavenCentral()
}

dependencies {
    implementation("junit:junit:4.13.2")
    implementation(kotlin("stdlib-jdk8", "1.4.31"))
    //implementation("org.apache.maven.plugins:maven-dependency-plugin:3.0.0")
}
*/

//repositories.gradlePluginPortal()
/*
tasks {
    register("a") {
      repositories.forEach {
          println(it.name)
      }
    }
}
*/
/*
buildscript {
    dependencies {
        "classpath"("org.apache.maven:maven-embedder:3.8.1")
    }
}
*/

//implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.31")

// implementation(kotlin("stdlib-jdk8", "1.4.31"))

//implementation("org.apache.maven:maven-project:2.2.1")
//implementation("org.apache.maven.plugins:maven-dependency-plugin:3.2.0")

/*
class MvnDependencyReportTask : DependencyReportTask() {
    render
}
DependencyReportTask()
*/
//tasks {
/*
    register<DependencyReportTask>("conf2") {
        setRenderer(object : DependencyReportRenderer {
            override fun setClientMetaData(clientMetaData: BuildClientMetaData) = Unit
            override fun setOutput(textOutput: StyledTextOutput) = Unit
            override fun setOutputFile(file: File) = Unit
            override fun startProject(project: ProjectDetails) = Unit
            override fun completeProject(project: ProjectDetails) = Unit
            override fun complete() = Unit
            override fun startConfiguration(configuration: Configuration) = Unit
            override fun completeConfiguration(configuration: Configuration) = Unit
            override fun render(configuration: Configuration) {
                configuration.resolvedConfiguration.resolvedArtifacts.forEach {
                    println("mvn dependency:copy -DoutputDirectory=build/maven-dependency-copy -Dartifact=${it.moduleVersion.id}")
                }
            }
        })
    }
*/
/*
register("conf") {
    doLast {
        System.setProperty("maven.multiModuleProjectDirectory", "./m2")
        println("=========================")
        org.apache.maven.cli.MavenCli.doMain(arrayOf("help:help"), null)
        println("=========================")


        buildDir.resolve("conf").mkdirs()
        buildDir.resolve("conf/fetch.sh").printWriter().use { out ->
            configurations["compileClasspath"].resolvedConfiguration.resolvedArtifacts.forEach {
                println("=========================")
                org.apache.maven.cli.MavenCli.doMain(arrayOf("dependency:copy", "-Dmaven.multiModuleProjectDirectory=./m2", "-DoutputDirectory=build/maven-dependency-copy", "-Dartifact=${it.moduleVersion.id}"), null)
                println("=========================")
                out.print("mvn dependency:copy -DoutputDirectory=build/maven-dependency-copy -Dartifact=${it.moduleVersion.id}")
                out.print("\n")
            }
        }
    }
}
}
*/
//DependencyReportTask

/*

configurations.testImplementation.get().dependencies.forEach {
    println()
}

println("=====")
repositories.forEach {
    println(it)
}
*/
