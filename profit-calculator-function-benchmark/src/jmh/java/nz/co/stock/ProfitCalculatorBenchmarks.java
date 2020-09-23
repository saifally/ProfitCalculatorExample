package nz.co.stock;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class ProfitCalculatorBenchmarks {

	/*
	 * Measures the performance of Brute force logic
	 */

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public void measureCalculateMaxProfitForStockPricesBruteForce() throws InterruptedException {
		
		List<Integer> dataForBenchmark = IntStream.rangeClosed(0, 1000)
			    .boxed().collect(Collectors.toList());
		ProfitCalculator classUnderTest = new ProfitCalculator();
		classUnderTest.calculateMaxProfitForStockPricesInOnePass(dataForBenchmark);
	}

	/*
	 * Measures the performance of Brute force logic
	 */

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public void measureCalculateMaxProfitForStockPricesUsingStream() throws InterruptedException {
		List<Integer> dataForBenchmark = IntStream.rangeClosed(0, 1000)
			    .boxed().collect(Collectors.toList());
		ProfitCalculator classUnderTest = new ProfitCalculator();
		
		classUnderTest.calculateMaxProfitForStockPricesUsingStream(dataForBenchmark);
	}

	/*
	 * This benchmark type measures the performance of the logic
	 */

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public void measureCalculateMaxProfitForStockPricesInOnePass() throws InterruptedException {
		
		List<Integer> dataForBenchmark = IntStream.rangeClosed(0, 1000)
			    .boxed().collect(Collectors.toList());
		ProfitCalculator classUnderTest = new ProfitCalculator();
		
		classUnderTest.calculateMaxProfitForStockPricesInOnePass(dataForBenchmark);
	}

	/*
	 *
	 * Run the Java API of JMH
	 */

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(".*" + ProfitCalculatorBenchmarks.class.getSimpleName() + ".*")
				.warmupIterations(1)
				.measurementIterations(1)
				.forks(1)
				.build();

		new Runner(opt).run();
	}

}
