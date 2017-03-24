# Vehicles Simple Service Rest

###  Architecture
The implementation of this solution is based on a service interface that provides the feature requested. The back-end is based on a data-manager interface accessible from the service implementation.

##### Framework
The framework used is Spring, configured using ApplicationConfig and annotations.
(For the Rest API implementation I use Spring Boot)

##### Service layer
The Service interface "VehiclesSimpleService" provides the methods:
 - 1
 - 2
 - 3

##### Data layer
 The interface "DataManager" provides the data management:
 - 1
 - 2
 - 3

> **Note:** VehiclesSimpleService provides to check if data are valid (throwing exception in case of null, or undefined) then returns the list of Vehicles filtered, ordered and ranked by DataManager.

----------

##### Project Structure
![VehiclesSimpleServiceTest project structure](VehiclesSimpleServiceRest/doc/project-structure.jpg)

----------

##### Class diagram
![VehiclesSimpleServiceTest class diagram](VehiclesSimpleServiceRest/doc/class-diagram.jpg)

----------

###  Library used


###  Execution Part 1
VehiclesSimpleServiceTest is a maven project, you can import into Eclipse as a maven project.

Using the command
```
maven clean install
```
maven will compile and will execute the tests.

To view the solution requested I provided a Main Class "Console.java" executable 

###  Execution Part 2

...
...
...



> **Note:** The version of Java is 1.7 

----------

###  Documentation
[JavaDoc](https://github.com/fabriziozandonella/vehicles-Simple-Service-Rest/tree/master/VehiclesSimpleServiceRest/doc) 

----------

