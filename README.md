# Jersey 2 with Guice 4
This project template demonstrates how to wire Jersey 2 and Guice 4 together.

## How to Build and Run the Project
This project uses the [Gradle](https://gradle.org) build system, you can build the project locally just by typing the following in the console:

```
./gradlew build
```

The output of the Gradle build is located in the  `build/` directory.

To run the project deploy the war-File in the `build\libs` directory to the application server of your choice.
Alternatively you can use the Gradle Jetty plugin:

```
./gradlew jettyRun
```

### How to Extend the Project
If you want to import the project in an IDE such as Eclipse or IntelliJ IDEA then Gradle provides a way to generate all the necessary project files.

Generate Eclipse project:
```
./gradlew cleanEclipse eclipse
```

Generate IntelliJ IDEA project:
```
./gradlew cleanIdea idea
```