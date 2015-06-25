# simplespring

## Project Set Up
1. Clone the repository
2. Navigate to your project directory.

    ```
    ./gradlew clean build
    ```

3. Initialize the database.

    ```
    ./gradlew dbInit
    ```

4. Migrate the database.

    ```
    ./gradlew setEnv flywayMigrate
    ```

## Running the App
1. Set your profile to the local profile.

    ```
    export PROFILE=local
    ```

2. Run the application.

    ```
    ./gradlew clean compileJava runApp`
    ```

## Unit Tests
1. From your project directory, run

    ```
    ./gradlew clean build
    ```

## Database
We use flyway for our database migration tool. Flyway comes with a lot of commands out of the box.
- `./gradlew flywayMigrate` : Migrates the database
- `./gradlew flywayClean` : Drops all objects in the configured schemas
- `./graldew flywayInfo` : Prints the details and status information about all the migrations
- `./gradlew flywayValidate` :	Validates the applied migrations against the ones available on the classpath
- `./gradlew flywayBaseline` :	Baselines an existing database, excluding all migrations up to and including baselineVersion
- `./gradlew flywayRepair` :	Repairs the metadata table


