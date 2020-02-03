[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](index.md) / [readWhile](./read-while.md)

# readWhile

`fun readWhile(predicate: (current: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Reads all characters starting from the [next](next.md) character while the [predicate](read-while.md#juuxel.leafthrough.StringReader$readWhile(kotlin.Function1((kotlin.Char, kotlin.Boolean)))/predicate) returns true.

### Exceptions

`IllegalStateException` - if this reader cannot read any characters