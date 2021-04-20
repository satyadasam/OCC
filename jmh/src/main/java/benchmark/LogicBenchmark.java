package benchmark;

import computelogic.ComputeLogicWithBurstsortImpl;
import computelogic.ComputeLogicWithJavaSortImpl;
import computelogic.ComputeLogicWithTrieImpl;
import interfaces.ComputeLogic;
import org.openjdk.jmh.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LogicBenchmark {

	@State(Scope.Benchmark)
	public static class StateComputeLogic {
		private final ComputeLogic computeLogicWithJavaSortImpl = new ComputeLogicWithJavaSortImpl();
		private final ComputeLogic computeLogicWithTrieImpl = new ComputeLogicWithTrieImpl();
		private final ComputeLogic computeLogicWithBurstsortImpl = new ComputeLogicWithBurstsortImpl();
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode({ Mode.Throughput, Mode.AverageTime })
	public void computeLogicWithSortSmallFile(StateComputeLogic st) {
		String names = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
		st.computeLogicWithJavaSortImpl.compute(names);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode({ Mode.Throughput, Mode.AverageTime })
	public void computeLogicWithSortLargeFile(StateComputeLogic st) {
		var file = new File("jmh/src/main/resources/source.txt");
		var path = Paths.get(file.getAbsolutePath());
		List<String> allLines = null;

		try {
			allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		var names = allLines.get(0);
		st.computeLogicWithJavaSortImpl.compute(names);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode({ Mode.Throughput })
	// @BenchmarkMode({Mode.Throughput,Mode.AverageTime})
	public void computeLogicWithTrieSmallFile(StateComputeLogic st) {
		String names = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
		st.computeLogicWithTrieImpl.compute(names);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode({ Mode.Throughput })
	// @BenchmarkMode({Mode.Throughput,Mode.AverageTime})
	public void computeLogicWithTrieLargeFile(StateComputeLogic st) {
		var file = new File("jmh/src/main/resources/source.txt");
		var path = Paths.get(file.getAbsolutePath());
		List<String> allLines = null;

		try {
			allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		var names = allLines.get(0);
		st.computeLogicWithTrieImpl.compute(names);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode({ Mode.Throughput })
	// @BenchmarkMode({Mode.Throughput,Mode.AverageTime})
	public void computeLogicWithBurstsortSmallFile(StateComputeLogic st) {
		String names = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
		st.computeLogicWithBurstsortImpl.compute(names);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode({ Mode.Throughput })
	// @BenchmarkMode({Mode.Throughput,Mode.AverageTime})
	public void computeLogicWithBurstsortLargeFile(StateComputeLogic st) {
		var file = new File("jmh/src/main/resources/source.txt");
		var path = Paths.get(file.getAbsolutePath());
		List<String> allLines = null;

		try {
			allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		var names = allLines.get(0);
		st.computeLogicWithBurstsortImpl.compute(names);
	}
}
