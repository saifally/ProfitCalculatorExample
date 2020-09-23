ProfitCalculatorBenchmarks
==================

```./gradlew jmh```

Sample report


| Benchmark                                          |  Mode |  Cnt |       Score   |     Error |   Units |
| -------------------------------------------------- | ----- | -----|-------------- |-----------|---------|
| measureCalculateMaxProfitForStockPricesBruteForce  |  avgt |    5 |   54961.749 ± |  6175.260 |   ns/op |
| measureCalculateMaxProfitForStockPricesInOnePass   |  avgt |    5 |   24939.187 ± |  5072.907 |   ns/op |
| measureCalculateMaxProfitForStockPricesUsingStream |  avgt |    5 |   48819.312 ± | 18243.961 |   ns/op |
