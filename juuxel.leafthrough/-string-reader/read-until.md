[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](index.md) / [readUntil](./read-until.md)

# readUntil

`fun readUntil(char: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`, inclusive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, peek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Reads until the [char](read-until.md#juuxel.leafthrough.StringReader$readUntil(kotlin.Char, kotlin.Boolean, kotlin.Boolean)/char) is encountered and returns the read characters.

### Parameters

`inclusive` - true if the last character should be read and included in the result

`peek` - true if the cursor should not be moved

### Exceptions

`IllegalStateException` - if this reader cannot read any characters