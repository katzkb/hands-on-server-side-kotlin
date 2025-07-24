# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Kotlin JVM project using Gradle as the build system. It's a basic "Hello World" application set up for server-side Kotlin development.

## Commands

### Build and Development
- `./gradlew build` - Builds the project and runs tests
- `./gradlew clean` - Cleans build artifacts
- `./gradlew jar` - Creates a JAR file
- `./gradlew classes` - Compiles main classes only

### Testing
- `./gradlew test` - Runs all tests using JUnit Platform
- `./gradlew testClasses` - Compiles test classes only

### Verification
- `./gradlew check` - Runs all verification tasks including tests

## Architecture

- **Language**: Kotlin 2.2.0 targeting JVM 24
- **Build System**: Gradle with Kotlin DSL
- **Testing**: JUnit Platform (configured but no tests present yet)
- **Package Structure**: Main code in `helloworld` package under `src/main/kotlin/`
- **Entry Point**: `helloworld.Main.kt` contains the main function

## Development Notes

- Kotlin code style is set to "official" in gradle.properties
- No application plugin is configured, so there's no `run` task available
- To run the application, use `./gradlew jar` then `java -jar build/libs/hands-on-server-side-kotlin-1.0-SNAPSHOT.jar` or add the application plugin to build.gradle.kts

## Git Commit Guidelines

This project follows the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification for commit messages.

### Commit Message Format

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

### Types
- `feat`: A new feature
- `fix`: A bug fix
- `docs`: Documentation only changes
- `style`: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)
- `refactor`: A code change that neither fixes a bug nor adds a feature
- `perf`: A code change that improves performance
- `test`: Adding missing tests or correcting existing tests
- `build`: Changes that affect the build system or external dependencies
- `ci`: Changes to CI configuration files and scripts
- `chore`: Other changes that don't modify src or test files

### Examples
- `feat: add user authentication`
- `fix: resolve memory leak in data processing`
- `docs: update API documentation`
- `build: upgrade Kotlin to 2.2.0`