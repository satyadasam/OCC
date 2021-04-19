package benchmark;

import app.Application;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

public class AppBenchmark {

    @State(Scope.Benchmark)
    public static class StateApplication {
        private Application app = new Application();
    }
}
