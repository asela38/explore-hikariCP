# explore-hikariCP
Exploring options of hikari Connection Pool

Task 3: 

Maven Core Plugins

maven-surefire-plugin : plugin behind test
  - ensure unit tests will run reliable and consistent results
  - Surefire suggest reliability in execution of tests
  - 
maven-failsafe-plugin : integration tests
  - this will not fail the build immediately
  - in case if surefire was used in 'integration-test' the build would have stopped 
    at the integration-test phase without any required cleanup


Task 2:

Add Spring-boot-starter-parent
- Better dependency management
  - For maven
    - maven-failsafe-plugin : To run integration tests
      - Name failsafe was chosen because it is a synonym of surefire and because it implies that when it fails it does so in a safe way
      - 4 phases of integration tests
        - pre-integration-test: setting up integration test environment
        - integration-test: for running the integration tests
        - post-integration-test: tearing down test environment
        - verify: for checking the resulst of integration tests
    - maven-jar-plugin
    - maven-surefire-plugin : To Run unit tests
- default configuration plugin
- inherits for spring-boot-dependencies


Task 1:
Add Maven framework support

- in 3 words: Java build tool

- in 10 words: Java build tool for dependency management and project automation

- in 1 sentence: "Maven is build automation and project management tool used for simplifying build process managing dependencies and enforcing project structure and best practices in software development "

- in 10 sentence
* Build Automation: Compiling source code to package and distribution
* Dependency Management:  Download and manages dependencies
* Consistency: Standard project structure and lifecyle
* Plugin Ecosystem:
* Community Support
