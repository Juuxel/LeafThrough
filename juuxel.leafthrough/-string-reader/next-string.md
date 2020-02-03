[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](index.md) / [nextString](./next-string.md)

# nextString

`fun nextString(amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, peek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Reads the next characters (equal to the [amount](next-string.md#juuxel.leafthrough.StringReader$nextString(kotlin.Int, kotlin.Boolean)/amount)).

### Parameters

`peek` - true if the cursor is not moved

### Exceptions

`IllegalStateException` - if this reader cannot read any characters