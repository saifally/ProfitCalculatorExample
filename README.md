# Profit Calculator Example

##### The ProfitCalculator has 3 different types of methods to Calculate maximum profit

`calculateMaxProfitForStockPricesUsingBruteForce`
As the name says - Brute force , originally written for TDD

`calculateMaxProfitForStockPricesInOnePass`
Old school but very efficient - twice as fast as per benchmarks

`calculateMaxProfitForStockPricesUsingStream`
Using Java 8 stream and a bit less efficient but more readable


##### Project setup
This project is using Gradle Multi modules

https://docs.gradle.org/current/userguide/multi_project_builds.html

The Intent is to isolate 2 concerns
- Code and its unit test
- Benchmarking the logic
