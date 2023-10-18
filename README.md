# Journey to Microservices #

This code demonstrates the process of moving from a monolithic architecture to a microservice. 

You can find both projects under the **mono** and **micro** branches in this repository. 

## Prerequisites #

You must have **Java 17** and **Maven** installed to run these projects.

## Running the code #

The code can be run for either project by checking out the correct branch, going into the project folder **j2m-demo** and **microservice** in a terminal/command prompt. 

Running the following command: `mvn spring-boot:run`

For the monolithic project only **j2m-demo** needs to run

For the microservice both **j2m-demo** and **microservice** need to be run. You can open up two terminal/command prompt windows for this.

## Accessing the Page #

Once the application is running, you can access the page by opening a web browser (i.e. Chrome, Safari, Firefox) and navigating to: http://localhost:8080

The microservice runs at http://localhost:8081. There is no ui at that service. You will find a Demo.md file in the microservice branch with curl instructions on how to interact with the service on the terminal/command prompt. 
