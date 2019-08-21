package part_3;

/** An instance is an ordered pair of integers */
public class Pair {
	public int one; // the ordered pair (one, two)
	public int two;

	/** Constructor: a pair of ints h and k. */
	public Pair(int h, int k) {
		one = h;
		two = k;
	}

	/** A representation (h, k) of this pair. */
	@Override
	public String toString() {
		return "(" + one + ", " + two + ")";
	}

}