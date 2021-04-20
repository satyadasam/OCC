package computelogic;

import interfaces.ComputeLogic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestComputeLogicWithBurstsortImpl {

    private ComputeLogic computeLogic;

    @Before
    public void init() {
        computeLogic = new ComputeLogicWithBurstsortImpl();
    }

    @Test
    public void testComupteLogic(){
        String names = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        var result = computeLogic.compute(names);
        Assert.assertEquals("3194",result.getValue());
    }

    @Test
    public void testComupteLogic_ErrorMessage(){
        String names = "";
        var result = computeLogic.compute(names);
        Assert.assertEquals("Unable to compute score",result.getValue());
    }
}
