# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a server-side Kotlin learning project using Gradle as the build system. The project is designed for hands-on Kotlin development practice, implementing various concepts and patterns commonly used in server-side applications.

### Learning Objectives

This project follows the "Hands-on Server-side Kotlin Development (Spring Boot & Arrow)" handbook and covers:
- Kotlin fundamentals and best practices
- Spring Boot web application development
- RESTful API design and implementation
- Error handling with Arrow
- Domain-driven design principles
- CRUD operations and data persistence

### Reference Material
[Implementing Server-side Kotlin Development](https://zenn.dev/msksgm/books/implementing-server-side-kotlin-development)

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
- **Package Structure**: Organized by feature/domain under `src/main/kotlin/`
- **Current State**: Starting with basic Hello World implementation in `helloworld` package
- **Planned Evolution**: Will expand to include domain models, services, and API controllers

## Development Notes

- Kotlin code style is set to "official" in gradle.properties
- This is a learning project - implementations may evolve as new concepts are explored
- Dependencies will be added incrementally as features are implemented (Spring Boot, Arrow, etc.)
- No application plugin is currently configured, so there's no `run` task available
- To run the current application, use `./gradlew jar` then `java -jar build/libs/hands-on-server-side-kotlin-1.0-SNAPSHOT.jar`

### Learning Progression

1. **Phase 1**: Kotlin basics and Hello World (Current)
2. **Phase 2**: Spring Boot setup and basic web APIs
3. **Phase 3**: Domain modeling and business logic
4. **Phase 4**: Error handling with Arrow
5. **Phase 5**: Complete CRUD application with persistence

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

### Commit Message Preferences
- Keep commit messages to a single line only
- Do not include detailed bullet point lists in commit body
- Do not include Co-Authored-By lines in commit messages
- Do not include "Generated with Claude Code" footer