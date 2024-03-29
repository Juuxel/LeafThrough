# Changelog

Using the [Keep a Changelog](https://keepachangelog.com/en/1.1.0/) format.

## [1.3.3] - 2022-04-30

### Changed
- Updated to Kotlin 1.6.21.
- Now compiles to Java 8 bytecode.

## [1.3.2] - 2021-01-12

### Fixed
- `StringReader.readWhile` crashing when the cursor was at the end of the source.

## [1.3.1] - 2021-01-08

### Changed
- Updated to Kotlin 1.4.21.

## [1.3.0] - 2020-02-15

### Added
- `StringReader.expect(String)`
  - Expects the passed string to be at the cursor.
- `StringReader.resetTo(String)`
  - Changes the source and resets the cursor.

### Fixed
- `StringReader.readUntil()` moved the cursor when `inclusive = false` and the string was empty.

## [1.2.0] - 2020-02-13

### Added
- `StringReader.getRemaining()`
  - Gets everything in the string after the cursor.

### Fixed
- Cursor offsets when using `readWhile()`.

## [1.1.0] - 2020-02-03

### Added
- `StringReader.readWhile((Char) -> Boolean)`
  - Reads until the given predicate returns false.

## [1.0.0] - 2020-02-03
Initial release.
