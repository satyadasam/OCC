package entity;

import java.math.BigDecimal;

/*An entity to hold the score value in different formats i,e, Integer, Long , BigDecimal etc.
Can be extended with additional values like Float, Double. value() method needs to be called for the String representation
If no value is set a default error message will be returned*/
public class ScoreHolder {

    private BigDecimal bigDecimalScore;

    private Long longScore;

    private Integer intScore;

    private final String message = "Unable to compute score";

    public ScoreHolder(){
        this.bigDecimalScore = null;
        this.longScore = null;
    }

    public ScoreHolder(BigDecimal bigDecimalScore){
        this.bigDecimalScore = bigDecimalScore;
        this.longScore = null;
        this.intScore = null;

    }

    public ScoreHolder(Long longScore){
        this.longScore = longScore;
        this.bigDecimalScore = null;
        this.intScore = null;
    }

    public ScoreHolder(Integer intScore){
        this.intScore = intScore;
        this.bigDecimalScore = null;
        this.longScore = null;
    }

    /*Returns String representation of data if any, else returns an error mesage String*/
    public String getValue(){

         if(bigDecimalScore !=null)
             return bigDecimalScore.toString();

         else if(longScore !=null)
             return longScore.toString();

         else if(intScore !=null)
             return intScore.toString();

         else
             return message;
    }

}
