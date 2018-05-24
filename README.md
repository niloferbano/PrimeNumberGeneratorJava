# PrimeNumberGeneratorJava
This project generates prime numbers between two given numbers. There are four stratergies to generate prime numbers
User can get the prime numbers through commandline or through a rest api call, with an in memory database(H2) to store the 
requests executed by the application.

## Getting Started

### Prerequisites

* Git
* JDK 8 or later
* Maven 3.0 or later

### Clone
To get started you can simply clone this repository using git:
```
git clone https://github.com/niloferbano/PrimeNumberGeneratorJava.git
cd PrimeNumberGeneratorJava
```

### Build an executable JAR

You can run the application from the command line using:
```
mvn spring-boot:run
```
Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```
## Running the tests

You can run the application from the command line using:
```
mvn spring-boot:run
```
Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```


```
Example for REST call
```
http://localhost:8080/primegenerator/{method to be used[1/2/3/4]}/{low_range}/{high_range}
1 for Naive approach
2 for slightly better optimization than 1st strategy
3 for a quick execution
4 parallel execution for large numbers

low_range Starting range
high_range End range

for example http://localhost:8080/primegenerator/1/1/100




