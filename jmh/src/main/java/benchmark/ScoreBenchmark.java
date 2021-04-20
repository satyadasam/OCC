package benchmark;

import computelogic.ComputeLogicWithBurstsortImpl;
import computelogic.ComputeLogicWithJavaSortImpl;
import computelogic.ComputeLogicWithTrieImpl;
import interfaces.ComputeLogic;
import org.openjdk.jmh.annotations.*;
import solution.ComputeScore;

import java.io.File;

public class ScoreBenchmark {

	@State(Scope.Benchmark)
	public static class StateComputeScore {
		private final ComputeScore computeScore = new ComputeScore();
		private final ComputeLogic computeLogicWithJavaSortImpl = new ComputeLogicWithJavaSortImpl();
		private final ComputeLogic computeLogicWithTrieImpl = new ComputeLogicWithTrieImpl();
		private final ComputeLogic computeLogicWithBurstsortImpl = new ComputeLogicWithBurstsortImpl();
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public void computeScoreWithSortLargeFile(StateComputeScore state) {
		System.out.println("here");
		var file = new File("jmh/src/main/resources/source.txt");
		var absolutePath = file.getAbsolutePath();

		state.computeScore.compute(absolutePath, state.computeLogicWithJavaSortImpl);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public void computeScoreWithSortSmallFile(StateComputeScore state) {
		System.out.println("here");
		var file = new File("jmh/src/main/resources/sourcesmalldata.txt");
		var absolutePath = file.getAbsolutePath();
		state.computeScore.compute(absolutePath, state.computeLogicWithJavaSortImpl);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public void computeScoreWithTrieLargeFile(StateComputeScore state) {
		System.out.println("here");
		var file = new File("jmh/src/main/resources/source.txt");
		var absolutePath = file.getAbsolutePath();
		state.computeScore.compute(absolutePath, state.computeLogicWithTrieImpl);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public void computeScoreWithTrieSmallFile(StateComputeScore state) {
		System.out.println("here");
		var file = new File("jmh/src/main/resources/sourcesmalldata.txt");
		var absolutePath = file.getAbsolutePath();
		state.computeScore.compute(absolutePath, state.computeLogicWithTrieImpl);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public void computeScoreWithBurstsortLargeFile(StateComputeScore state) {
		System.out.println("here");
		var file = new File("jmh/src/main/resources/source.txt");
		var absolutePath = file.getAbsolutePath();
		state.computeScore.compute(absolutePath, state.computeLogicWithBurstsortImpl);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public void computeScoreWithBurstsortSmallFile(StateComputeScore state) {
		System.out.println("here");
		var file = new File("jmh/src/main/resources/sourcesmalldata.txt");
		var absolutePath = file.getAbsolutePath();
		state.computeScore.compute(absolutePath, state.computeLogicWithBurstsortImpl);
	}

}
