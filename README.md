# Leaf Through

![](https://img.shields.io/github/license/Juuxel/LeafThrough?color=green) ![](https://img.shields.io/github/workflow/status/Juuxel/LeafThrough/Kotlin%20CI) ![](https://img.shields.io/github/v/release/Juuxel/LeafThrough)

> *leaf through*
> 1. To turn the pages of (a book) idly, reading short sections at random.

A small string reading library for Kotlin.

```kotlin
val reader = StringReader("hello (world)")
val hello = reader.readUntil(' ', peek = true) // does not move the cursor
hello.readUntil('(') // "hello "
hello.expect('(') // throws if the next character is not '('
```

## Usage

You can get it from either [Jitpack](https://jitpack.io)
or the [CottonMC repository](http://server.bbkr.space:8081/artifactory/webapp/).

Gradle:
```kotlin
repositories {
    maven {
        name = "Cotton"
        url = uri("http://server.bbkr.space:8081/artifactory/libs-release")
    }
}

dependencies {
    implementation("io.github.juuxel:leaf-through:1.0.0")
}
```
