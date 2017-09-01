# Java 8 Learning
The code in this repo is related to the tutorial done at http://winterbe.com/posts/2014/03/16/java-8-tutorial/ <br>
Its recommended that you follow along with this tutorial to better understand what this repo does.

## Streams
Note there is a more specialized tutorial on Streams. This is a more advanced function the rest of the Java 8 features
shown.
This can be found at: http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

The more comprehensive stream example in the main Java 8 tutorial can be found in Streams.java


## How to Run

The there two ways to execute this work. Debug way and Gradle.

To use Gradle:

There are two tasks:
- `gradle build` to generate the class files
- `gradle run` to execute the main class

To debug you must execute the HelloWorld Class, like so:

1. Open the project into InteliJ IDEA or Eclipse.
2. Locate the HelloWorld Class under src/main/java/hello.
3. Create a breakpoint somewhere in the main function to stop at.
4. Right click on the HelloWorld Class and Debug the main function.