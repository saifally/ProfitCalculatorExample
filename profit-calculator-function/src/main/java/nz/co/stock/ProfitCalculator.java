package nz.co.stock;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/*
 * This Java file has few methods to calculate the maximum profit for a given list of stock prices
 */
public class ProfitCalculator {

	// Brute force , a bit inefficient but good for TDD , Benchmark and Readability
	public Integer calculateMaxProfitForStockPricesUsingBruteForce(List<Integer> stockPrices) {

		// We need minimum two prices
		if (stockPrices.size() < 2) {
			return 0;
		}

		// First pass , get the position of the lowest stock price, ignore the last one
		// , we have to sell before that
		int minStockPriceIndex = IntStream.range(0, stockPrices.size() - 1)
				.boxed()
				.min(comparingInt(stockPrices::get))
				.get();

		// Second and smaller pass, get Maximum price after minimum has happened
		int maxStockPriceIndex = IntStream.range(minStockPriceIndex, stockPrices.size())
				.boxed()
				.max(comparingInt(stockPrices::get))
				.get();

		// System.out.println(maxStockPriceIndex+"-"+minStockPriceIndex);
		// 3rd and 4th fetch
		return stockPrices.get(maxStockPriceIndex) - stockPrices.get(minStockPriceIndex);

	}

	// One Pass using Pre Java 8 , Old school
	// Can not be done in Java 8 because lambdas can not use global variable
	public Integer calculateMaxProfitForStockPricesInOnePass(List<Integer> stockPrices) {

		// Initialize the values
		Integer lowestStockPrice = stockPrices.get(0);
		Integer maxProfit = 0;
		Integer profit = 0;

		for (Integer stockPrice : stockPrices) {
			// Keep assigning the lowest stock prices
			if (lowestStockPrice > stockPrice) {
				lowestStockPrice = stockPrice;
			} else {
				profit = stockPrice - lowestStockPrice;
			}

			// Keep checking if there is a bigger profit
			if (profit > maxProfit) {
				maxProfit = profit;
			}
		}
		return maxProfit;
	}

	// Java 8 code , a bit more efficient
	public Integer calculateMaxProfitForStockPricesUsingStream(List<Integer> stockPrices) {

		// We need minimum two prices
		if (stockPrices.size() < 2) {
			return 0;
		}

		// First pass , get the position of the lowest stock price, ignore the last one
		// , we have to sell before that
		int minStockPriceIndex = IntStream.range(0, stockPrices.size() - 1)
				.boxed()
				.min(comparingInt(stockPrices::get))
				.get();

		// Second operation , fetch the lowest value
		int mimimumStockPrice = stockPrices.get(minStockPriceIndex);

		// Third and smaller pass, get Maximum price after Minimum has happened
		Integer maximumProfit = stockPrices.subList(minStockPriceIndex, stockPrices.size())
				.stream()
				.map(stockPrice -> (stockPrice - mimimumStockPrice))
				.max(Comparator.comparing(Integer::valueOf))
				.get();

		return maximumProfit;
	}

}
