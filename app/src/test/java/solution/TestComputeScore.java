package solution;

import computelogic.ComputeLogicWithBurstsortImpl;
import computelogic.ComputeLogicWithJavaSortImpl;
import computelogic.ComputeLogicWithTrieImpl;
import interfaces.ComputeLogic;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class TestComputeScore {

	@Test
	public void testComputeWithTrie() {
		var logic = new ComputeScore();
		var file = new File("src/test/resources/source.txt");
		var absolutePath = file.getAbsolutePath();
		final ComputeLogic computeLogic = new ComputeLogicWithTrieImpl();
		var score = logic.compute(absolutePath, computeLogic);
		Assert.assertEquals("871198282", score);
	}

	@Test
	public void testComputeWithJavaSort() {
		var logic = new ComputeScore();
		var file = new File("src/test/resources/source.txt");
		var absolutePath = file.getAbsolutePath();
		final ComputeLogic computeLogic = new ComputeLogicWithJavaSortImpl();
		var score = logic.compute(absolutePath, computeLogic);
		Assert.assertEquals("871198282", score);
	}

	@Test
	public void testComputeWithBurstsort() {
		var logic = new ComputeScore();
		var file = new File("src/test/resources/source.txt");
		var absolutePath = file.getAbsolutePath();
		final ComputeLogic computeLogic = new ComputeLogicWithBurstsortImpl();
		var score = logic.compute(absolutePath, computeLogic);
		Assert.assertEquals("871198282", score);
	}

}
