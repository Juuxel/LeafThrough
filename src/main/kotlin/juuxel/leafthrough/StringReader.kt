package juuxel.leafthrough

/**
 * A `StringReader` can be used to read through a string to find or expect
 * single chars.
 *
 * Inspired by the `StringReader` found in [Brigadier](https://github.com/Mojang/brigadier).
 *
 * @property source the source string to read from
 */
class StringReader(val source: String) {
    /**
     * The cursor represents the next character that will be read.
     * Starts from zero.
     */
    var cursor: Int = 0

    /**
     * Copies the [source] of the [other] reader, but not its cursor position.
     */
    constructor(other: StringReader) : this(other.source)

    init {
        require(source.isNotEmpty()) { "The source must not be empty!" }
    }

    /**
     * Throws an [IllegalStateException] if this reader cannot read any characters.
     */
    private fun throwIfFinished(offset: Int = 0) {
        if (!hasNext(offset)) error("Expected ${offset + 1} characters, but only ${source.length - cursor} found!")
    }

    /**
     * Returns true if this reader can still read characters.
     */
    operator fun hasNext(): Boolean = cursor < source.length

    /**
     * Returns true if this reader can still read characters after applying an offset.
     *
     * @param offset the cursor offset (characters after the next one, 0 means the next character)
     */
    fun hasNext(offset: Int): Boolean = cursor + offset < source.length

    /**
     * Reads the next character and moves the cursor forward.
     *
     * @throws IllegalStateException if this reader cannot read any characters
     */
    operator fun next(): Char {
        throwIfFinished()
        return source[cursor++]
    }

    /**
     * Reads the next character after applying the [offset] and moves the cursor forward by `offset + 1`.
     *
     * @param offset the reading offset (characters after the next one, 0 means the next character)
     * @throws IllegalStateException if this reader cannot read any characters
     */
    fun next(offset: Int): Char {
        throwIfFinished(offset)
        cursor += offset
        return source[cursor++]
    }

    /**
     * Reads the next characters (equal to the [amount]).
     *
     * @param peek true if the cursor is not moved
     * @throws IllegalStateException if this reader cannot read any characters
     */
    fun nextString(amount: Int, peek: Boolean = false): String {
        throwIfFinished(amount - 1)
        val c = cursor
        val d = cursor + amount
        if (!peek) {
            cursor += amount
        }
        return source.substring(c, d)
    }

    /**
     * Reads the next character without moving the cursor.
     *
     * @param offset the reading offset (characters after the next one, 0 means the next character)
     * @throws IllegalStateException if this reader cannot read any characters
     */
    fun peek(offset: Int = 0): Char {
        throwIfFinished(offset)
        return source[cursor + offset]
    }

    /**
     * Reads the next character without moving the cursor.
     * Returns null if there are no characters left.
     *
     * @param offset the reading offset (characters after the next one, 0 means the next character)
     */
    fun peekOrNull(offset: Int = 0): Char? =
        if (hasNext(offset)) source[cursor + 1 + offset]
        else null

    /**
     * Expects the next character to be [char]. If not, throws an [IllegalStateException].
     *
     * @param peek true if the cursor is not moved forward
     */
    fun expect(char: Char, peek: Boolean = false) {
        val next = if (peek) peek() else next()
        if (next != char) {
            val c = if (peek) cursor + 1 else cursor
            error("Expected character at $c to be '$char', but it was '$next'!")
        }
    }

    /**
     * Reads until the [char] is encountered and returns the read characters.
     *
     * @param inclusive true if the last character should be read and included in the result
     * @param peek true if the cursor should not be moved
     * @throws IllegalStateException if this reader cannot read any characters
     */
    fun readUntil(char: Char, inclusive: Boolean = false, peek: Boolean = false): String {
        throwIfFinished()
        fun read(c: Int) = if (peek) peek(c) else next()

        val builder = StringBuilder()

        if (peek() == char) {
            if (!peek) next()
            return if (inclusive) "$char" else ""
        }

        var i = 0
        var current = read(i++)

        while (current != char && hasNext()) {
            builder.append(current)
            current = read(i++)
        }

        if (inclusive) {
            builder.append(current)
        } else if (!peek) { // move cursor backwards
            cursor--
        }

        return builder.toString()
    }

    /**
     * Reads all characters starting from the [next] character while the [predicate] returns true.
     *
     * @throws IllegalStateException if this reader cannot read any characters
     */
    fun readWhile(predicate: (current: Char) -> Boolean): String {
        throwIfFinished()

        val builder = StringBuilder()

        do {
            val current = next()
            if (predicate(current)) {
                builder.append(current)
            } else {
                break
            }
        } while (hasNext())

        cursor-- // move back the cursor by one unit

        return builder.toString()
    }

    /**
     * Resets the [cursor] to zero.
     */
    fun reset() {
        cursor = 0
    }

    override fun toString() = "StringReader(source=$source, cursor=$cursor)"
}
