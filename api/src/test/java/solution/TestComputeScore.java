package solution;


import computelogic.ComputeLogicImplWithTrie;
import interfaces.ComputeLogic;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class TestComputeScore {

    @Test
    public void testCompute(){
        var logic = new ComputeScore();
        var file = new File("src/test/resources/source.txt");
        var absolutePath = file.getAbsolutePath();
        final ComputeLogic computeLogic = new ComputeLogicImplWithTrie();
        var score =  logic.compute(absolutePath,computeLogic);
        Assert.assertEquals("871198282",score);
    }


}
