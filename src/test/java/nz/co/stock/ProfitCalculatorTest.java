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

	@ParameterizedTest( name = "#{index} calculateMaxProfitForStockBruteForce - Test Case ={1}")
	@MethodSource("generateData")
	public void testCalculateMaxProfitForStockBruteForce( int index, String testCase, List<Integer> stockPrices, Integer expectedProfit) {
        ProfitCalculator classUnderTest = new ProfitCalculator();
        Assertions.assertEquals(expectedProfit, classUnderTest.calculateMaxProfitForStockBruteForce(stockPrices));
    }

	static Stream<Arguments> generateData() {
	    return Stream.of(
	        Arguments.of(1, "NegativeTestNoStockPrices", Arrays.asList(0),0)
	    );
	}
}
