[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](index.md) / [peek](./peek.md)

# peek

`fun peek(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)

Reads the next character without moving the cursor.

### Parameters

`offset` - the reading offset (characters after the next one, 0 means the next character)

### Exceptions

`IllegalStateException` - if this reader cannot read any characters