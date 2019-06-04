package part_2;
/**
 *
 */

/**
 * @author frankomullo
 *
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Permutation {

	/**
	 * Implement the function: Boolean isStringPermutation(String s1, String s2)
	 * This function takes two strings and returns true if one string is a
	 * permutation of the other, false otherwise.
	 */
	static HashMap<Character, Integer> h = new HashMap<>();

	public static boolean isStringPermutation(String s1, String s2) {
		//return true if one string is the permutation of the other, false
		// otherwise.

		// check if the strings are same length
		if (s1.length() != s2.length()) {
			return false;
		}
		// traverse the first string and keep count of the number of occurrence of each
		// char in the string, and store it in the hm.
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (h.containsKey(c)) {
				int val = h.get(c) + 1;
				h.put(c, val);
			} else {
				h.put(c, 1);
			}
		}
		/**
		 * traverse 2nd string, comparing the occurences of its characters to the ones
		 * in the hashmap, if the characters have equal occurences in both strings, then
		 * it is likely a permutation.
		 */

		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (h.containsKey(c)) {
				int val = h.get(c);
				if (val == 0) {
					return false;
				}
				val--;
				h.put(c, val);
			} else {
				return false;
			}
		}
		//check that all the keys have a numerical value of 0 bc of the decrementing, else, false
		Set<Character> keys = h.keySet();
		Iterator<Character> iterator = keys.iterator();
		while (iterator.hasNext()) {
			char c = iterator.next();
			if (h.get(c) != 0) {
				return false;
			}
		}
		return true;

	}
}
