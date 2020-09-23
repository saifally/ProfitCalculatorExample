package nz.co.stock;

/*
 * Test different methods of ProfitCalculator
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProfitCalculatorTest {

	@ParameterizedTest(name = "#{index} calculateMaxProfitForStockPricesUsingBruteForce - Test Case ={1}")
	@MethodSource("generateData")
	public void testCalculateMaxProfitForStockPricesUsingBruteForce(int index, String testCase,
			List<Integer> stockPrices, Integer expectedProfit) {
		ProfitCalculator classUnderTest = new ProfitCalculator();
		Assertions.assertEquals(expectedProfit,
				classUnderTest.calculateMaxProfitForStockPricesUsingBruteForce(stockPrices));
	}

	@ParameterizedTest(name = "#{index} calculateMaxProfitForStockPricesUsingStream - Test Case ={1}")
	@MethodSource("generateData")
	public void testCalculateMaxProfitForStockPricesUsingStream(int index, String testCase, List<Integer> stockPrices,
			Integer expectedProfit) {
		ProfitCalculator classUnderTest = new ProfitCalculator();
		Assertions.assertEquals(expectedProfit, classUnderTest.calculateMaxProfitForStockPricesUsingStream(stockPrices));
	}

	@ParameterizedTest(name = "#{index} calculateMaxProfitForStockPricesInOnePass - Test Case ={1}")
	@MethodSource("generateData")
	public void testCalculateMaxProfitForStockPricesInOnePass(int index, String testCase, List<Integer> stockPrices,
			Integer expectedProfit) {
		ProfitCalculator classUnderTest = new ProfitCalculator();
		Assertions.assertEquals(expectedProfit, classUnderTest.calculateMaxProfitForStockPricesInOnePass(stockPrices));
	}

	static Stream<Arguments> generateData() {
		return Stream.of(Arguments.of(1, "LowestAtMidDayMaxEndofTheDay", Arrays.asList(4, 2, 1, 3, 7), 6),
				Arguments.of(2, "LowestAtMidDaySecondHighestMaxAtEndofTheDay", Arrays.asList(4, 8, 2, 1, 3, 7), 6),
				Arguments.of(3, "LowestAtStartOfTheDayMaxEndOfTheDay", Arrays.asList(3, 4, 5), 2),
				Arguments.of(4, "LowestAtTheEndOfTheDayHoweverTooLateToSell", Arrays.asList(2, 4, 1), 2),
				Arguments.of(5, "TwoLowestHoweverMaxIsAfterSecondLowest", Arrays.asList(2, 4, 2, 6, 1), 4),
				Arguments.of(6, "TwoLowestHoweverMaxIsAfterFirstLowest", Arrays.asList(2, 6, 2, 4, 1), 4),
				Arguments.of(7, "TwoSellOpportunity", Arrays.asList(2, 6, 2, 6, 2), 4),
				Arguments.of(8, "NegativeTestTooLateToSell", Arrays.asList(2, 1), 0),
				Arguments.of(9, "NegativeTestFlatPriceAllDay", Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1), 0),
				Arguments.of(10, "NegativeTestNoStockPrices", Arrays.asList(0), 0));
	}
}
