# Gmail Mock

## Project Structure

The project is organized into the following modules:

- **app**: Contains the main application code.
- **data**: Manages data sources and repositories.
- **domain**: Contains business logic and use cases.
- **presentation**: Handles UI and presentation logic.
- **core-ui**: Holds compose component
- **core**: Contains common utility or extension functions

## Dependencies

The project uses the following key dependencies:

- **Kotlin**: The primary programming language.
- **Jetpack Compose**: For building the UI.
- **Hilt**: For dependency injection.
- **JUnit 5**: For unit testing.
- **MockK**: For mocking in tests.
- **Kotest**: For assertions and test runners.
- **AndroidX Test**: For UI testing.
- **Screenshot**: For screenshot testing.

## Testing Frameworks

The project uses the following testing frameworks:

- **JUnit 5**: For unit tests.
- **Kotest**: For assertions and test runners.
- **MockK**: For mocking dependencies.
- **AndroidX Test**: For UI tests.
- **Turbine**: For flows.
- **Compose Screenshot Testing**: For screenshot-based UI tests.

## Running Tests

To run the tests, use the following Gradle commands:

- **Unit Tests**:
  ```sh
  ./gradlew runAllUnitTests

## Screenshot Tests

To run the
```sh
./gradlew validateDebugScreenshotTest