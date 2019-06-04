package part_5;

public class Hanoi {

	public static void Hanoi(int n, int start, int goal, int temp) {
		// base case
		if (n == 0) {
			return;
		}
		// only one disc in the tower, just move it
		if (n == 1) {
			System.out.println("Move from" + start + "to" + goal);
		}
		/**
		 * first move the top n-1 disks temporarily to "temp" then move the largest disk
		 * to the target peg. Then move the remaining n-1 disks back on top of the
		 * largest @ target.
		 */
		// temporarily move all but the last disk to the "other peg"
		Hanoi(n - 1, temp, goal, start);

		// move the last disk to the target peg
		System.out.println("move from " + start + " to " + goal);

		// now move all but the last disk to the target peg
		Hanoi(n - 1, temp, goal, start);

	}

}
