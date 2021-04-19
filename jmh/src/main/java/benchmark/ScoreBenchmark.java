package benchmark;

import computelogic.ComputeLogicImpl;
import computelogic.ComputeLogicImplWithBurstsort;
import computelogic.ComputeLogicImplWithTrie;
import interfaces.ComputeLogic;
import org.openjdk.jmh.annotations.*;
import solution.ComputeScore;

import java.io.File;

public class ScoreBenchmark {


    @State(Scope.Benchmark)
    public static class StateComputeScore {
        private final ComputeScore computeScore = new ComputeScore();
        private final ComputeLogic computeLogicWithSort = new ComputeLogicImpl();
        private final ComputeLogic computeLogicImplWithTrie = new ComputeLogicImplWithTrie();
        private final ComputeLogic computeLogicImplWithBurstsort = new ComputeLogicImplWithBurstsort();
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void computeScoreWithSortLargeFile(StateComputeScore state) {
        System.out.println("here");
        var file = new File("jmh/src/main/resources/source.txt");
        var absolutePath = file.getAbsolutePath();

        state.computeScore.compute(absolutePath, state.computeLogicWithSort);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void computeScoreWithSortSmallFile(StateComputeScore state) {
        System.out.println("here");
        var file = new File("jmh/src/main/resources/sourcesmalldata.txt");
        var absolutePath = file.getAbsolutePath();
        state.computeScore.compute(absolutePath, state.computeLogicWithSort);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void computeScoreWithTrieLargeFile(StateComputeScore state) {
        System.out.println("here");
        var file = new File("jmh/src/main/resources/source.txt");
        var absolutePath = file.getAbsolutePath();
        state.computeScore.compute(absolutePath, state.computeLogicImplWithTrie);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void computeScoreWithTrieSmallFile(StateComputeScore state) {
        System.out.println("here");
        var file = new File("jmh/src/main/resources/sourcesmalldata.txt");
        var absolutePath = file.getAbsolutePath();
        state.computeScore.compute(absolutePath, state.computeLogicImplWithTrie);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void computeScoreWithBurstsortLargeFile(StateComputeScore state) {
        System.out.println("here");
        var file = new File("jmh/src/main/resources/source.txt");
        var absolutePath = file.getAbsolutePath();
        state.computeScore.compute(absolutePath, state.computeLogicImplWithBurstsort);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void computeScoreWithBurstsortSmallFile(StateComputeScore state) {
        System.out.println("here");
        var file = new File("jmh/src/main/resources/sourcesmalldata.txt");
        var absolutePath = file.getAbsolutePath();
        state.computeScore.compute(absolutePath, state.computeLogicImplWithBurstsort);
    }

}
