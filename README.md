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

You can get it from my Bintray repository (might be on JCenter in the future).

Gradle:
```kotlin
repositories {
    maven {
        url = uri("https://dl.bintray.com/juuxel/maven")
    }
}

dependencies {
    implementation("io.github.juuxel:leaf-through:1.3.1")
}
```
