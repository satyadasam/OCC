package computelogic;

import entity.ScoreHolder;
import interfaces.ComputeLogic;
import util.Burstsort;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ComputeLogicWithBurstsortImpl implements ComputeLogic {

    private static final Logger logger = Logger.getLogger(ComputeLogicWithBurstsortImpl.class);

    @Override
    public ScoreHolder compute(String namesInFile) {

        logger.debug("::: In compute method");
        ScoreHolder scoreValue = new ScoreHolder();

        try {
            String[] list =  (Arrays.stream(namesInFile.split("," )))
                            .parallel().map(ss->ss.substring(1, ss.length()-1))
                            .toArray(size->new String[size]);

            Burstsort.sort(list);

            BigDecimal score = 	IntStream.range(0, list.length).parallel()
                    .mapToLong(e->list[e].chars().map(c->c-64).sum()*(e+1))
                    .mapToObj(bd->new BigDecimal(bd))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            scoreValue = new ScoreHolder(score);
        }
        catch (Exception e){
            logger.error("Error computing score " + e);
        }
        return scoreValue;
    }
}
