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

## Example for REST call

http://localhost:8080/primegenerator/{1/2/3/4}/{low_range}/{high_range}
* 1 -  Naive approach
* 2 -  slightly better optimization than 1st strategy
* 3 - a quick execution
* 4 - parallel execution for large numbers

* low_range - Starting range
* high_range - End range

for example http://localhost:8080/primegenerator/1/1/100

Commandline version can be used from IDE console or by running the jar file.




