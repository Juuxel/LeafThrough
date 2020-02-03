[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](index.md) / [hasNext](./has-next.md)

# hasNext

`operator fun hasNext(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if this reader can still read characters.

`fun hasNext(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if this reader can still read characters after applying an offset.

### Parameters

`offset` - the cursor offset (characters after the next one, 0 means the next character)