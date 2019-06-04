package part_4;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** an instance is a singly linked list */

public class SLList<E> implements Iterable<E> {

	private Node first;
	/** Last node of linked list (null if size is 0) */
	private Node last;
	/** Number of nodes in the linked list */
	private int size;

	/** Constructor: an empty linked list. */
	public SLList() {
	}

	/**
	 * = the number of values in this list. <br>
	 * This function takes constant time.
	 */
	public int size() {
		return size;
	}

	/**
	 * First value in the list. <br>
	 * Throw a NoSuchElementException if list is empty.
	 */
	public E first() {
		if (size == 0)
			throw new NoSuchElementException();
		return first.val;
	}

	/**
	 * = the last value of the list. <br>
	 * Throw a NoSuchElementException if list is empty.
	 */
	public E last() {
		if (size == 0)
			throw new NoSuchElementException();
		return last.val;
	}

	/** = the first node of the list (null if the list is empty). */
	public Node firstNode() {
		return first;
	}

	/** = the last node of the list (null if the list is empty). */
	public Node lastNode() {
		return last;
	}

	/**
	 * = the value of node n of this list. This function takes constant time.<br>
	 * Precondition: n is a node of this list; it may not be null.
	 */
	public E value(Node n) {
		assert n != null;
		return n.val;
	}

	/**
	 * add value v to the end of the list. <br>
	 * This operation takes constant time.
	 */

	public void pushBack(E v) {
		Node n = new Node(v, null);
		// set forward link
		if (size == 0)
			first = n;
		else
			last.next = n;

		last = n;
		size = size + 1;
	}

	public Node getNode(int h) {
		//This method should take time proportional to min(h, size-h).
		// For example, if h <= size/2, search from the beginning of the
		// list, otherwise search from the end of the list.
		assert 0 <= h && h < size;
		Node n = first;
		// invariant: n points to node i of the list
		for (int i = 0; i < h; i = i + 1) {
			n = n.next;
		}
		// n points to node h
		return n;
	}

	public void erase(Node n) {
		Node temp = first;
		while (temp.next != null && temp.val != n.val) {
			temp = temp.next;
		}
		if (temp.next != null) {
			temp.next = temp.next.next;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	// TODO Auto-generated constructor stub

	/** An instance is a node of this list. */
	public class Node {
		private E val; // The value of this element
		private Node next; // Next node on list. (null if this is last node)

		/**
		 * Constructor: an instance with
		 * value and next node n (can be null).
		 */
		Node(E v, Node n) {
			val = v;
			next = n;
		}

		/** Return the value of this node. */
		public E value() {
			return val;
		}

		/**
		 * Return the next node in this list (null if this is the last node of this
		 * list).
		 */
		public Node next() {
			return next;
		}
	}
}
