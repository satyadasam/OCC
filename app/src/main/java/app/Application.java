package app;

import computelogic.ComputeLogicWithBurstsortImpl;
import computelogic.ComputeLogicWithJavaSortImpl;
import computelogic.ComputeLogicWithTrieImpl;
import interfaces.ComputeLogic;
import org.apache.log4j.BasicConfigurator;
import solution.ComputeScore;

public class Application {

	public static void main(String[] args) {
		BasicConfigurator.configure();

		System.out.println("Please enter complete file path along with its name");

		String path = System.console().readLine();

		System.out.println(
				"Please specify the computation logic: 1 for jdk java sort, 2 for standard trie, 3 for burstsort");
		ComputeScore computeScore = new ComputeScore();
		String logicMethod = System.console().readLine();
		ComputeLogic computeLogic = null;
		if (logicMethod.equalsIgnoreCase("1"))
			computeLogic = new ComputeLogicWithJavaSortImpl();
		else if (logicMethod.equalsIgnoreCase("2"))
			computeLogic = new ComputeLogicWithTrieImpl();
		else if (logicMethod.equalsIgnoreCase("3"))
			computeLogic = new ComputeLogicWithBurstsortImpl();
		computeScore.compute(path, computeLogic);

	}
}
