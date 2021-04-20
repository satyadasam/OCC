package entity;

import org.junit.Assert;
import org.junit.Test;
import solution.ComputeScore;

import java.io.File;
import java.math.BigDecimal;

public class TestScoreHolder {

    @Test
    public void testMessage(){
        ScoreHolder score = new ScoreHolder();
        Assert.assertEquals("Unable to compute score",score.getValue());
    }

    @Test
    public void testBigDecimal(){
        ScoreHolder score = new ScoreHolder(BigDecimal.ONE);
        Assert.assertEquals("1",score.getValue());
    }

    @Test
    public void testLong(){
        ScoreHolder score = new ScoreHolder(1l);
        Assert.assertEquals("1",score.getValue());
    }

    @Test
    public void testInt(){
        ScoreHolder score = new ScoreHolder(1);
        Assert.assertEquals("1",score.getValue());
    }

}
