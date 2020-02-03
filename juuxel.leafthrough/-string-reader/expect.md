[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](index.md) / [expect](./expect.md)

# expect

`fun expect(char: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`, peek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Expects the next character to be [char](expect.md#juuxel.leafthrough.StringReader$expect(kotlin.Char, kotlin.Boolean)/char). If not, throws an [IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html).

### Parameters

`peek` - true if the cursor is not moved forward