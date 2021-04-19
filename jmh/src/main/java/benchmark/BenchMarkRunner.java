package benchmark;

import org.apache.log4j.BasicConfigurator;

public class BenchMarkRunner {
        public static void main(String[] args) throws Exception {
            BasicConfigurator.configure();
            org.openjdk.jmh.Main.main(args);
        }
    }

