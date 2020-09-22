package nz.co.stock;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/*
 * This Java file has few methods to calculate the maximum profit for a given list of stock prices
 */
public class ProfitCalculator {

	// Brute force , a bit inefficient but good for TDD , Benchmark and readablility
	public Integer calculateMaxProfitForStockBruteForce(List<Integer> stockPrices) {

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

}
