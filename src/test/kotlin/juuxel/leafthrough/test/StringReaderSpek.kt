package juuxel.leafthrough.test

import juuxel.leafthrough.StringReader
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isNotNull
import strikt.assertions.isNull

class StringReaderSpek : Spek({
    Feature("String readers") {
        val reader by memoized { StringReader("hello (world)") }

        Scenario("reading a character") {
            var char: Char? = null
            When("a character is read") {
                char = reader.next()
            }

            Then("it should be 'h' (the first character)") {
                expectThat(char).isEqualTo('h')
            }

            Then("the cursor should have moved") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(1)
            }
        }

        Scenario("peeking a character") {
            var char: Char? = null
            When("a character is peeked") {
                char = reader.peek()
            }

            Then("it should be 'h' (the first character)") {
                expectThat(char).isEqualTo('h')
            }

            Then("the cursor should not have moved") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(0)
            }
        }

        Scenario("peeking a character optionally") {
            var char: Char? = '*'
            When("a character is peeked from the end") {
                char = reader.peekOrNull(reader.source.length)
            }

            Then("it should be null") {
                expectThat(char).isNull()
            }
        }

        Scenario("reading N characters") {
            lateinit var result: String
            When("the first 5 characters are read") {
                result = reader.nextString(5)
            }

            Then("the string should be 'hello'") {
                expectThat(result).isEqualTo("hello")
            }

            Then("the cursor should have moved") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(5)
            }
        }

        Scenario("peeking N characters") {
            lateinit var result: String
            When("the first 5 characters are peeked") {
                result = reader.nextString(5, peek = true)
            }

            Then("the string should be 'hello'") {
                expectThat(result).isEqualTo("hello")
            }

            Then("the cursor should not have moved") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(0)
            }
        }

        Scenario("reading the whole string") {
            lateinit var result: String
            When("the whole string is read") {
                result = reader.nextString(reader.source.length)
            }

            Then("the string should be equal to the source") {
                expectThat(result).isEqualTo(reader.source)
            }

            Then("the reader should have nothing left") {
                expectThat(reader).assertThat("is finished") { !it.hasNext() }
            }
        }

        Scenario("resetting the reader") {
            When("the whole string is read and the reader is reset") {
                reader.nextString(reader.source.length)
                reader.reset()
            }

            Then("the reader's cursor should be at zero") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(0)
            }
        }

        Scenario("expecting a present character") {
            var result: Result<Unit>? = null
            When("the character 'h' is expected") {
                result = runCatching { reader.expect('h') }
            }

            Then("it should have succeeded") {
                expectThat(result)
                    .isNotNull()
                    .assertThat("is successful") { it.isSuccess }
            }

            Then("the cursor should have moved") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(1)
            }
        }

        Scenario("expecting an absent character") {
            var result: Result<Unit>? = null
            When("the character 'X' is expected") {
                result = runCatching { reader.expect('X') }
            }

            Then("it should have failed") {
                expectThat(result)
                    .isNotNull()
                    .assertThat("is failure") { it.isFailure }
            }
        }

        Scenario("reading until a character") {
            lateinit var result: String
            When("the string is read until '('") {
                result = reader.readUntil('(')
            }

            Then("the result should be the string before '('") {
                expectThat(result).isEqualTo(reader.source.substringBefore('('))
            }

            Then("the cursor should have moved") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(reader.source.indexOf('('))
            }
        }

        Scenario("peeking until a character") {
            lateinit var result: String
            When("the string is read until '('") {
                result = reader.readUntil('(', peek = true)
            }

            Then("the result should be the string before '('") {
                expectThat(result).isEqualTo(reader.source.substringBefore('('))
            }

            Then("the cursor should not have moved") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(0)
            }
        }

        Scenario("reading until a character (inclusive)") {
            lateinit var result: String
            When("the string is read until '('") {
                result = reader.readUntil('(', inclusive = true)
            }

            Then("the result should be the string until and including '('") {
                expectThat(result).isEqualTo(reader.source.substring(0, reader.source.indexOf('(') + 1))
            }

            Then("the cursor should have moved") {
                expectThat(reader)
                    .get("cursor") { cursor }
                    .isEqualTo(reader.source.indexOf('(') + 1)
            }
        }
    }
})
