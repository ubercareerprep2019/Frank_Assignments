package part_2;

public class BST<T extends Comparable<T>> {
	private T value;

	/**
	 * All values in left are less than value. All values in right are greater than
	 * value.
	 */
	private BST<T> left, right;

	public BST(T value) {
		this.value = value;
	}

	private int safeSize(BST<T> t) {
		return t == null ? 0 : t.size();
	}

	public int size() {
		return 1 + safeSize(left) + safeSize(right);
	}

	// find helper function
	private boolean safeContains(BST<T> t, T v) {
		return t == null ? false : t.find(v);
	}

	/**
	 * Checks whether or not a key exists in this binary search tree. If there are n
	 * nodes in the tree, then the average runtime of this method should be log(n).
	 *
	 * @param key The key to check for.
	 * @return true if the key is present in this binary search tree, false
	 *         otherwise.
	 */

	public boolean find(T v) {
		int i = v.compareTo(value);
		if (i < 0) {
			return safeContains(left, v);
		} else if (i > 0) {
			return safeContains(right, v);
		} else /* i == 0 */ {
			return true;
		}
	}

	/**
	 * Inserts a key into this binary search tree. If there are n nodes in the tree,
	 * then the average runtime of this method should be log(n).
	 *
	 * @param key The key to insert.
	 */

	public void insert(T v) {
		int i = v.compareTo(value);
		if (i < 0) {
			if (left == null) {
				left = new BST<>(v);
			} else {
				left.insert(v);
			}
		} else if (i > 0) {
			if (right == null) {
				right = new BST<>(v);
			} else {
				right.insert(v);
			}
		} else /* i == 0 */ {
			return;
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 5, 2, 7, 4 };
		BST<Integer> bst = new BST<>();
		for (Integer n : a) {
			bst.insert(n);
			System.out.println();
		}
	}

}
