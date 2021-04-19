package app;

import computelogic.ComputeLogicImplWithTrie;
import interfaces.ComputeLogic;
import org.apache.log4j.BasicConfigurator;
import solution.ComputeScore;

public class Application {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        System.out.println("Please enter file path");

        String path = System.console().readLine();

        ComputeScore computeScore = new ComputeScore();

        final ComputeLogic computeLogic = new ComputeLogicImplWithTrie();

        computeScore.compute(path,computeLogic);

    }
}
