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

		return 0;

	}

}
