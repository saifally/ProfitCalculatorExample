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

		// Second and smaller pass, get maximum price after minimum has happened
		int maxStockPriceIndex = IntStream.range(minStockPriceIndex, stockPrices.size())
				.boxed()
				.max(comparingInt(stockPrices::get))
				.get();

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
		int minStockPrice = stockPrices.get(minStockPriceIndex);

		// Third and smaller pass, get Maximum price after Minimum has happened
		Integer maximumProfit = stockPrices.subList(minStockPriceIndex, stockPrices.size())
				.stream()
				.map(stockPrice -> (stockPrice - minStockPrice))
				.max(Comparator.comparing(Integer::valueOf))
				.get();

		return maximumProfit;
	}

	// Divide and Conquer approach - recursively splits the problem into smaller subproblems
	public Integer calculateMaxProfitForStockPricesUsingDivideAndConquer(List<Integer> stockPrices) {
		// We need minimum two prices
		if (stockPrices.size() < 2) {
			return 0;
		}
		
		return divideAndConquerHelper(stockPrices, 0, stockPrices.size() - 1);
	}
	
	private Integer divideAndConquerHelper(List<Integer> stockPrices, int low, int high) {
		// Base case: if we have only one element, no profit can be made
		if (low >= high) {
			return 0;
		}
		
		// Base case: if we have only two elements, return the profit or 0
		if (high - low == 1) {
			return Math.max(0, stockPrices.get(high) - stockPrices.get(low));
		}
		
		int mid = low + (high - low) / 2;
		
		// Calculate maximum profit in left half
		int leftMaxProfit = divideAndConquerHelper(stockPrices, low, mid);
		
		// Calculate maximum profit in right half
		int rightMaxProfit = divideAndConquerHelper(stockPrices, mid + 1, high);
		
		// Calculate maximum profit that crosses the middle point
		// Find minimum price in left half
		int minLeftPrice = stockPrices.get(low);
		for (int i = low; i <= mid; i++) {
			minLeftPrice = Math.min(minLeftPrice, stockPrices.get(i));
		}
		
		// Find maximum price in right half
		int maxRightPrice = stockPrices.get(mid + 1);
		for (int i = mid + 1; i <= high; i++) {
			maxRightPrice = Math.max(maxRightPrice, stockPrices.get(i));
		}
		
		int crossMaxProfit = maxRightPrice - minLeftPrice;
		
		// Return the maximum of all three possibilities
		return Math.max(Math.max(leftMaxProfit, rightMaxProfit), crossMaxProfit);
	}

	// Dynamic Programming approach using memoization - more space efficient
	public Integer calculateMaxProfitForStockPricesUsingDP(List<Integer> stockPrices) {
		// We need minimum two prices
		if (stockPrices.size() < 2) {
			return 0;
		}
		
		int minPrice = stockPrices.get(0);
		int maxProfit = 0;
		
		// Single pass through the array
		// At each step, we either:
		// 1. Update the minimum price seen so far, or
		// 2. Calculate profit if we sell at current price and update max profit
		for (int i = 1; i < stockPrices.size(); i++) {
			int currentPrice = stockPrices.get(i);
			
			// Update minimum price if current price is lower
			if (currentPrice < minPrice) {
				minPrice = currentPrice;
			} else {
				// Calculate profit if we sell at current price
				int currentProfit = currentPrice - minPrice;
				maxProfit = Math.max(maxProfit, currentProfit);
			}
		}
		
		return maxProfit;
	}

}
