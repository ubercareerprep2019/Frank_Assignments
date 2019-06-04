package part_2;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class pairsThatEqualTest {

	@Test
	void testPairsThatEqual() {
		int[] inputArray = { 1, 2, 3 };
		int targetSum = 3;

		ArrayList<int[]> output = pairsThatEqual.pairsThatEqualSum(inputArray, targetSum);
		for (int[] x : output) {
			assertEquals(x[0] + x[1], targetSum);
		}
	}

}
