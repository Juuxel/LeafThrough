[leaf-through](../../index.md) / [juuxel.leafthrough](../index.md) / [StringReader](./index.md)

# StringReader

`class StringReader`

A `StringReader` can be used to read through a string to find or expect
single chars.

Inspired by the `StringReader` found in [Brigadier](https://github.com/Mojang/brigadier).

### Constructors

| [&lt;init&gt;](-init-.md) | Copies the [source](source.md) of the [other](-init-.md#juuxel.leafthrough.StringReader$<init>(juuxel.leafthrough.StringReader)/other) reader, but not its cursor position.`StringReader(other: `[`StringReader`](./index.md)`)`<br>A `StringReader` can be used to read through a string to find or expect single chars.`StringReader(source: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| [cursor](cursor.md) | The cursor represents the next character that will be read. Starts from zero.`var cursor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [source](source.md) | the source string to read from`val source: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [expect](expect.md) | Expects the next character to be [char](expect.md#juuxel.leafthrough.StringReader$expect(kotlin.Char, kotlin.Boolean)/char). If not, throws an [IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html).`fun expect(char: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`, peek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [hasNext](has-next.md) | Returns true if this reader can still read characters.`operator fun hasNext(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this reader can still read characters after applying an offset.`fun hasNext(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [next](next.md) | Reads the next character and moves the cursor forward.`operator fun next(): `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)<br>Reads the next character after applying the [offset](next.md#juuxel.leafthrough.StringReader$next(kotlin.Int)/offset) and moves the cursor forward by `offset + 1`.`fun next(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html) |
| [nextString](next-string.md) | Reads the next characters (equal to the [amount](next-string.md#juuxel.leafthrough.StringReader$nextString(kotlin.Int, kotlin.Boolean)/amount)).`fun nextString(amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, peek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [peek](peek.md) | Reads the next character without moving the cursor.`fun peek(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html) |
| [peekOrNull](peek-or-null.md) | Reads the next character without moving the cursor. Returns null if there are no characters left.`fun peekOrNull(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`?` |
| [readUntil](read-until.md) | Reads until the [char](read-until.md#juuxel.leafthrough.StringReader$readUntil(kotlin.Char, kotlin.Boolean, kotlin.Boolean)/char) is encountered and returns the read characters.`fun readUntil(char: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`, inclusive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, peek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readWhile](read-while.md) | Reads all characters starting from the [next](next.md) character while the [predicate](read-while.md#juuxel.leafthrough.StringReader$readWhile(kotlin.Function1((kotlin.Char, kotlin.Boolean)))/predicate) returns true.`fun readWhile(predicate: (current: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [reset](reset.md) | Resets the [cursor](cursor.md) to zero.`fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

