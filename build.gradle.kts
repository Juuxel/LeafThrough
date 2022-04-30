import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    `java-library`
    `maven-publish`

    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.dokka") version "1.6.21"
    id("org.jmailen.kotlinter") version "3.10.0"
}

group = "io.github.juuxel"
version = "1.3.2"

java {
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib"))

    val spek = "2.0.18"
    testImplementation("io.strikt:strikt-core:0.34.0")
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
