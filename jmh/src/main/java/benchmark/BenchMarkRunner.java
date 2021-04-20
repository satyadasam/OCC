package benchmark;

import org.apache.log4j.BasicConfigurator;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.VerboseMode;

public class BenchMarkRunner {
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();

		Options options = new OptionsBuilder().verbosity(VerboseMode.NORMAL).addProfiler(GCProfiler.class)
				.jvmArgs("-Xmx10g").build();
		new Runner(options).run();
	}
}


