package part_2;

public class BstPhoneBook<Key extends Comparable<Key>, Value> implements PhoneBook {

	private Node root;

	private class Node {
		private String name;
		private long phoneNumber;
		private Node left, right;
		private int size;

		public Node(String name, long phoneNumber, int size) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.size = size;
		}

	}

	public BstPhoneBook() {
	}

	/**
	 * @return The number of entries in this phone book.
	 */
	@Override
	public int size() {

		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		}
		return x.size;
	}

	/**
	 * Inserts an entry in this phone book.
	 *
	 * @param name        The name for the entry.
	 * @param phoneNumber The phone number for the entry.
	 */

	@Override
	public void insert(String name, long phoneNumber) {
		if (name == null) {
			throw new IllegalArgumentException("No name is defined");
		}
		root = insertHelper(root, name, phoneNumber);
	}

	private Node insertHelper(Node x, String name, long phoneNumber) {
		if (x == null) {
			return new Node(name, phoneNumber, 1);
		} else if (name.compareTo(x.name) < 0) {
			x.left = insertHelper(x.left, name, phoneNumber);
		} else if (name.compareTo(x.name) > 0) {
			x.left = insertHelper(x.right, name, phoneNumber);
		}
		x.phoneNumber = phoneNumber;
		x.size = 1 + size(x.left) + size(x.right);
		return x;

	}

	/**
	 * Returns the phone number associated with a name in the phone book.
	 *
	 * @param name The name to search for.
	 * @return The phone number for the entry, or -1 if the name is not present in
	 *         the phone book.
	 */

	@Override
	public long find(String name) {
		return finder(root, name);
	}

	private long finder(Node x, String name) {
		if (name == null) {
			throw new IllegalArgumentException("No name is defined");
		}
		if (x == null) {
			return -1;
		}
		int comparator = name.compareTo(x.name);
		if (comparator < 0) {
			return finder(x.left, name);
		}
		if (comparator > 0) {
			return finder(x.right, name);
		} else {
			return x.phoneNumber;
		}
	}

}
