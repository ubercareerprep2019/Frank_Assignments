package part_2;
/**
 *
 */

/**
 * @author frankomullo
 *
 */
import java.util.ArrayList;
import java.util.Arrays;

public class pairsThatEqual {
	public static ArrayList<int[]> pairsThatEqualSum(int[] inputArray, int targetSum) {
		//return an array of all pairs of integers from the input array whose sum
		// equal the the target
		Arrays.sort(inputArray);
		int start = 0;
		int end = inputArray.length - 1;
		ArrayList<int[]> arr = new ArrayList<>();
		while (start < end) {
			if (inputArray[start] + inputArray[end] == targetSum) {
				int[] array = { start, end };
				arr.add(array);
				start++;
				end--;
			}
			if (inputArray[start] + inputArray[end] < targetSum) {
				start++;
			} else if (inputArray[start] + inputArray[end] > targetSum) {
				end--;
			}

		}
		return arr;
	}
}
