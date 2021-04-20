package solution;

import entity.ScoreHolder;
import interfaces.ComputeLogic;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ComputeScore {

    private static final Logger logger = Logger.getLogger(ComputeScore.class);

    public String compute(String filePath, ComputeLogic computeLogic ) {

        BasicConfigurator.configure();
        logger.debug(" In compute method");
        ScoreHolder score = new ScoreHolder();//BigDecimal.ZERO;

        try {
            var namesInFile = extractDataFromFile(filePath);
            score = computeLogic.compute(namesInFile);
            System.out.println("Score of given file  = " + score.getValue());
        } catch (Exception e) {
            System.out.println("Score of given file for given file Path : " + filePath);
            logger.error("Error computing score " + e);
        }
         return score.getValue();
    }

  public String extractDataFromFile(String filePath){

        List<String> allLines = null;
        try {
            var path = Paths.get(filePath);
            allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.error("ComputeScore:::"+" extractDataFromFile" + " :::Exception while reading file "+e);
            e.printStackTrace();
        }

       assert allLines != null;
       return String.join("", allLines);//works if file has multiple lines
    }
}
