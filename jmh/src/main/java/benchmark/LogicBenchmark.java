package benchmark;

import computelogic.ComputeLogicImpl;
import computelogic.ComputeLogicImplWithBurstsort;
import computelogic.ComputeLogicImplWithTrie;
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
          private final ComputeLogic computeLogicWithSort = new ComputeLogicImpl();
          private final ComputeLogic computeLogicWithTrie = new ComputeLogicImplWithTrie();
          private final ComputeLogic computeLogicImplWithBurstsort = new ComputeLogicImplWithBurstsort();
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode({Mode.Throughput,Mode.AverageTime})
    public void computeLogicWithSortSmallFile(StateComputeLogic st) {
        String names = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        st.computeLogicWithSort.compute(names);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode({Mode.Throughput,Mode.AverageTime})
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
        st.computeLogicWithSort.compute(names);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode({Mode.Throughput})
    //@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
    public void computeLogicWithTrieSmallFile(StateComputeLogic st) {
        String names = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        st.computeLogicWithTrie.compute(names);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode({Mode.Throughput})
    //@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
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
        st.computeLogicWithTrie.compute(names);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode({Mode.Throughput})
    //@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
    public void computeLogicWithBurstsortSmallFile(StateComputeLogic st) {
        String names = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        st.computeLogicImplWithBurstsort.compute(names);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode({Mode.Throughput})
    //@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
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
        st.computeLogicImplWithBurstsort.compute(names);
    }
}
