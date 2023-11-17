# Scanner for input

This code was created for use in CSci 2101: Data Structures at the University of Minnesota Morris.

Students should continue following practices we have established in labs (e.g., working together, giving credit in git commits, using GitHub, writing tests, etc.). 
   
---
Review
   * Be able to use test/code coverage in VS Code (with Coverage Gutters, JaCoCo, and Maven all working together)
   * Understand how to run Maven commands to update coverage information
      * Much of the setup for using coverage in VS Code for a Java project came from [this post by Clark Jaskcon Ngo](https://medium.com/@clarkjasonngo/junit-test-with-maven-in-vscode-7546eabd50f7) that I found helpful
      * `mvn install` - uses your pom.xml file to load dependencies described there
      * `mvn package` - builds your project and runs your tests (I'm honestly not that sure why you would choose one or the other of these options between `install` and `package`)
      * `mvn clean jacoco:prepare-agent install jacoco:report` - This is the command from the Clark Jackson Ngo article... and there is another simlar comment from another posting... both seemed to work for me, but your experience may vary. I found the descriptions here about how to open the coverage reports helpful (right click, copy path, paste into browser of your choice).
      * `mvn jacoco:prepare-agent test install jacoco:report` - This is the command from another post I found (this one by [Karl Rombauts](https://medium.com/@karlrombauts/setting-up-unit-testing-for-java-in-vs-code-with-maven-3dc75579122f)). Both posts were helpful in different ways at different times.

The [instructions for this example](LABTASKS.md) are written in a markdown file.
