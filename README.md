# TestSpringSnap

[![Build Status](https://snap-ci.com/snap-ci/docs.snap-ci.com/branch/master/build_image)](https://snap-ci.com/sebradloff/testSpringSnap/branch/master)

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

    PROFILE=dev ./gradlew clean compileJava runApp

Access it through `localhost:8080` or `https://localhost:8443` on your browser

## Unit Tests
1. From your project directory, run

    ```
    ./gradlew clean build
    ```

## Functional Tests
1. `brew install phantomjs`
2. `PROFILE=test ./gradlew clean build compileJava functional`

## Database
We use flyway for our database migration tool. Flyway comes with a lot of commands out of the box.
- `./gradlew flywayMigrate` : Migrates the database
- `./gradlew flywayClean` : Drops all objects in the configured schemas
- `./graldew flywayInfo` : Prints the details and status information about all the migrations
- `./gradlew flywayValidate` :	Validates the applied migrations against the ones available on the classpath
- `./gradlew flywayBaseline` :	Baselines an existing database, excluding all migrations up to and including baselineVersion
- `./gradlew flywayRepair` :	Repairs the metadata table


## Backup Heroku DB
-To schedule your heroku db backup type this command from your command line assuming your repo is remotely connected to heroku: `heroku pg:backups schedule DATABASE_URL --at '02:00 America/Los_Angeles'`, this schedules a backup every day at 2:00PM PST
-To add a heroku backup to your SNAP-CI script when you deploy the app to Heroku: have `heroku pg:backups capture --app APP_NAME` as a command

##Deployment
To manually deploy to Heroku, or to view your commits on snapci follow these instructions:
- Hassle someone on the project team to get added to the testSpringSnap codebase on github
- This should give you magical access to the testSpringSnap SnapCI Pipeline, which you can see by logging into snapci.com with your github credentials
- You'll need to be added as a collaborator to access the heroku box (ask a team member)
- Install the heroku cli with brew `brew install heroku`
- Add the heroku remote head `git remote add heroku git@heroku.com:project.git`
- You can make sure you have it by `git remote`
- You'll need to put an ssh key up on heroku to be able to push to it `heroku keys:add ~/.ssh/id_rsa.pub`
- Now you can deploy! `git push heroku master`

## Runing the application on Https
You can run the application on https locally by typing `https://localhost:8443`.

## Configuration 
There are profiles configured for each type of environment (Dev, Test, Snap, Heroku). The application will use the 
profile that is set via the environment variables as PROFILE. If PROFILE is not set it will use the profile of dev as 
the default. The prefix used for that in the application is ${PROFILE:dev} indicating that if PROFILE is not set then it
will use dev.

Also, if you want to set the profile to something specific locally use the following syntax:

    PROFILE=<profile> ./gradlew <task(s)>
    
1. You will need the dev.properties and test.properties files for the project to work in your local environment. A sample of this file can be found as an attachment on the Mingle page. 
2. Whatever you do, DON'T PUSH okta_config.xml
