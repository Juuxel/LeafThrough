[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](index.md) / [peekOrNull](./peek-or-null.md)

# peekOrNull

`fun peekOrNull(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`?`

Reads the next character without moving the cursor.
Returns null if there are no characters left.

### Parameters

`offset` - the reading offset (characters after the next one, 0 means the next character)