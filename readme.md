About the project:

To run the automated test suite in docker environment.
It is a maven project with testNG as test runner, Java as coding language.

Required software: Java JDK 11+ Maven installed and in your classpath and maven sure fire plugin configured to run the tests from cmd line.


How to execute the tests: You can open each test class on src\test\java and execute all of them, but I recommend you run it by the command line. It enables us to run in a pipeline, that is the project purpose.


Running the test suites: Run docker-compose.yml up -d from cmd on the system with docker installed.(from the docker-compose.yml file located in the project).
This creates 3 containers : w2agrid, docker_nodechrome_1, docker_nodefirefox_1.
Once the above containers are started, Run the test suite in regular fashion from IDE. The tests will be run in the container.

About the Project Structure: src/main/java: Package: com.westwing.base: Base class to initiate the configuration file and initiate remote web driver to run in the container with the base url triggered. 
com.westwing.config: congfig file with all the necessary data in it.
com.westwing.pages: Page object model, with all the necessary pages interacted in the test suite are present as java class.
com.westwing.util: used to generate internal logs using webeventlisteners.

src/test/java: com.westwing.tests: All the tests are present here.

Patterns applied: Page Object Model & Page Factory with tests running in the container.

