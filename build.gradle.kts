import com.jfrog.bintray.gradle.BintrayExtension
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    `java-library`
    `maven-publish`

    kotlin("jvm") version "1.4.21"
    id("org.jetbrains.dokka") version "1.4.20"
    id("org.jmailen.kotlinter") version "3.3.0"
    id("com.jfrog.bintray") version "1.8.5"
}

group = "io.github.juuxel"
version = "1.3.1"

java {
    withSourcesJar()
}

repositories {
    jcenter()
}

dependencies {
    api(kotlin("stdlib"))

    val spek = "2.0.15"
    testImplementation("io.strikt:strikt-core:0.28.1")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek")
    testRuntimeOnly(kotlin("reflect"))
}

if (file("private.gradle").exists()) {
    apply(from = "private.gradle")
}

tasks {
    jar {
        from("LICENSE")
    }

    withType<DokkaTask> {
        dokkaSourceSets.configureEach {
            includes.from(file("src/docs/docs.md"))
        }
    }

    test {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

bintray {
    if (project.hasProperty("bintrayUser")) {
        user = project.property("bintrayUser").toString()
        key = project.property("bintrayKey").toString()
    } else {
        println("'bintrayUser' not found -- please set up 'bintrayUser' and 'bintrayKey' before publishing")
    }

    pkg(closureOf<BintrayExtension.PackageConfig> {
        repo = "maven"
        name = "leaf-through"
        setLicenses("MIT")
        vcsUrl = "https://github.com/Juuxel/LeafThrough"

        version(closureOf<BintrayExtension.VersionConfig> {
            name = project.version.toString()
        })
    })

    setPublications("maven")
}
