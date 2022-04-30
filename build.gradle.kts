import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    `maven-publish`
    signing

    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.dokka") version "1.6.21"
    id("org.jmailen.kotlinter") version "3.10.0"
}

group = "io.github.juuxel"
version = "1.3.3"

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

val javadocJar = tasks.register<Jar>("javadocJar") {
    val dokkaHtml = tasks.getByName<DokkaTask>("dokkaHtml")
    dependsOn(dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaHtml.outputDirectory)
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

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

    assemble {
        dependsOn(javadocJar)
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        artifact(javadocJar)

        pom {
            name.set("Leaf Through")
            description.set("A small string reading library for Kotlin")
            url.set("https://github.com/Juuxel/LeafThrough")

            licenses {
                license {
                    name.set("MIT License")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }

            developers {
                developer {
                    id.set("Juuxel")
                    name.set("Juuxel")
                    email.set("juuzsmods@gmail.com")
                }
            }

            scm {
                connection.set("scm:git:git://github.com/Juuxel/LeafThrough.git")
                developerConnection.set("scm:git:ssh://github.com/Juuxel/LeafThrough.git")
                url.set("https://github.com/Juuxel/LeafThrough")
            }
        }

        repositories {
            maven {
                name = "ossrh"
                url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials(PasswordCredentials::class)
            }
        }
    }
}

if (project.hasProperty("signing.keyId")) {
    signing {
        sign(publishing.publications)
    }
}
