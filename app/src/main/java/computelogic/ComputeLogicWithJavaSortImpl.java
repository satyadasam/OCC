package computelogic;

import entity.ScoreHolder;
import interfaces.ComputeLogic;
import org.apache.log4j.Logger;
import solution.ComputeScore;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputeLogicWithJavaSortImpl implements ComputeLogic {
    private static final Logger logger = Logger.getLogger(ComputeLogicWithJavaSortImpl.class);

    @Override
    public ScoreHolder compute(String namesInFile){
        logger.debug("::: In compute method");
        ScoreHolder scoreValue = new ScoreHolder();
        try {
        	
          /* List<String> list = Arrays.stream(namesInFile.split(","))
                    .parallel().map(ss -> ss.substring(1, ss.length() - 1))
                    .collect(Collectors.toList());
        	
        	 Collections.sort(list);
        	
        	          BigDecimal score = IntStream.range(0, list.size()).parallel()
            .mapToLong(e -> list.get(e).chars().map(c -> c - 64).sum() * (e + 1))
            .mapToObj(bd -> new BigDecimal(bd))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        	 */
        	
        	 String[] list = Arrays.stream(namesInFile.split(","))
                     .parallel().map(ss -> ss.substring(1, ss.length() - 1))
                     .toArray(size->new String[size]);

        	 Arrays.parallelSort(list);
        	 
             BigDecimal score = IntStream.range(0, list.length).parallel()
                     .mapToLong(e -> list[e].chars().map(c -> c - 64).sum() * (e + 1))
                     .mapToObj(bd -> new BigDecimal(bd))
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
        	 
            scoreValue = new ScoreHolder(score);
        }
        catch (Exception e){
            logger.error("Error computing score " + e);
        }
        return scoreValue;
    }
}

