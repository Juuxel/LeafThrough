[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](index.md) / [next](./next.md)

# next

`operator fun next(): `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)

Reads the next character and moves the cursor forward.

### Exceptions

`IllegalStateException` - if this reader cannot read any characters`fun next(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)

Reads the next character after applying the [offset](next.md#juuxel.leafthrough.StringReader$next(kotlin.Int)/offset) and moves the cursor forward by `offset + 1`.

### Parameters

`offset` - the reading offset (characters after the next one, 0 means the next character)

### Exceptions

`IllegalStateException` - if this reader cannot read any characters