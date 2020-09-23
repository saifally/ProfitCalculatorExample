ProfitCalculatorExampleBenchmarks
==================

```./gradlew jmh```

Sample report

Benchmark                                                                      Mode  Cnt      Score      Error  Units
ProfitCalculatorBenchmarks.measureCalculateMaxProfitForStockPricesBruteForce   avgt    5  22802.791 ±  466.015  ns/op
ProfitCalculatorBenchmarks.measureCalculateMaxProfitForStockPricesInOnePass    avgt    5  22587.716 ± 1128.114  ns/op
ProfitCalculatorBenchmarks.measureCalculateMaxProfitForStockPricesUsingStream  avgt    5  46750.708 ± 3098.476  ns/op
