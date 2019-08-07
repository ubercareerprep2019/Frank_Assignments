package part2;

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

	private boolean safeContains(BST<T> t, T v) {
		return t == null ? false : t.find(v);
	}

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

}