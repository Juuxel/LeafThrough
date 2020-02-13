plugins {
    `java-library`
    `maven-publish`
    id("com.jfrog.artifactory") version "4.9.0"

    kotlin("jvm") version "1.3.61"
    id("org.jetbrains.dokka") version "0.10.0"
    id("org.jmailen.kotlinter") version "2.3.0"
}

group = "io.github.juuxel"
version = "1.2.0"

repositories {
    jcenter()
}

dependencies {
    api(kotlin("stdlib"))

    val spek = "2.0.9"
    testImplementation("io.strikt:strikt-core:0.23.4")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek")
    testRuntimeOnly(kotlin("reflect"))
}

if (file("private.gradle").exists()) apply(from = "private.gradle")
apply(from = "artifactory.gradle") // artifactory doesn't really work with a kts buildscript

val sourcesJar = tasks.create<Jar>("sourcesJar") {
    group = "build"

    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

tasks {
    jar {
        from("LICENSE")
    }

    dokka {
        outputFormat = "markdown"
        outputDirectory = "$buildDir/dokka"

        configuration {
            includes = listOf("src/docs/docs.md")
        }
    }

    test {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }

    build {
        dependsOn(sourcesJar)
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        artifact(tasks["sourcesJar"])
    }
}
