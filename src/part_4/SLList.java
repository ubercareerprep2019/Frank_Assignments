package part_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** an instance is a singly linked list */
/**
 * I've modified my implementation so that for each can be used to iterate over
 * elements of list
 */

public class SLList<T> implements Iterable<T> {

	private Node first;
	/** Last node of linked list (null if size is 0) */
	private Node last;
	/** Number of nodes in the linked list */
	private int size;

	/** Constructor: an empty linked list. */
	public SLList() {
		first = null;
		last = null;
		size = 0;
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
	public T first() {
		if (isEmpty())
			throw new NoSuchElementException();
		return first.value();
	}

	/**
	 * = the last value of the list. <br>
	 * Throw a NoSuchElementException if list is empty.
	 */
	public T last() {
		if (isEmpty())
			throw new NoSuchElementException();
		return last.value();
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
	public T value(Node n) {
		assert n != null;
		return n.val;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * add value v to the end of the list. <br>
	 * This operation takes constant time.
	 */

	public void pushBack(T v) {
		Node n = new Node(v, null);
		// set forward link
		if (isEmpty()) {
			first = n;
		}

		else {
			last.setNext(n);

			last = n;
			size = size + 1;
		}

	}

	public T popBack() {
		T value = last.value();
		last = null;
		size -= 1;
		return value;

	}

	public void insert(int index, T data) {
		if (index < size + 1 && index > 0 || index == 0) {
			size++;
			Node n = new Node(data, getElementAt(index));
			if (index == 0) {
				first = n;

			} else {
				getElementAt(index - 1).setNext(n);
			}
		}
	}

	public Node getElementAt(int index) {
		int count = 0;
		Node curr = first;
		while (index < size && index >= 0) {
			if (count == index) {
				return curr;
			} else {
				curr = curr.next();
				count += 1;
			}
		}
		return null;
	}

	// alternative implementation of elementAt
//	public Node getNode(int h) {
//		// This method should take time proportional to min(h, size-h).
//		// For example, if h <= size/2, search from the beginning of the
//		// list, otherwise search from the end of the list.
//		assert 0 <= h && h < size;
//		Node n = first;
//		// invariant: n points to node i of the list
//		for (int i = 0; i < h; i = i + 1) {
//			n = n.next;
//		}
//		// n points to node h
//		return n;
//	}

	// helper function for element at
	private Node getNodeAt(int index) {
		Node curr = this.first;
		for (int i = 0; i < index; i++)
			curr = curr.next;
		return curr;
	}

	// Returns a single node at the index location in the list.
	public Node elementAt(int index) {
		Node result = null;
		if (0 <= index && index < this.size())
			result = this.getNodeAt(index);
		return result;

	}

	// Erases a single node at the index location in the list.
	public void erase(int index) {
		Node curr = first;
		if (index == 0) {
			first = curr.next;

		}
		int count = 0;
		Node prev = first;
		curr = first.next;
		while (curr != null) {
			if (count == index) {
				prev.next = curr.next;
			}
			count++;
			prev = curr;
			curr = curr.next;
		}
	}

	/** An instance is a node of this list. */
	public class Node {
		private T val; // The value of this element
		private Node next; // Next node on list. (null if this is last node)

		/**
		 * Constructor: an instance with value and next node n (can be null).
		 */
		Node(T v, Node n) {
			val = v;
			next = n;
		}

		/** Return the value of this node. */
		public T value() {
			return val;
		}

		/**
		 * Return the next node in this list (null if this is the last node of this
		 * list).
		 */
		public Node next() {
			return next;
		}

		// set the next node

		public void setNext(Node n) {
			next = n;
		}
	}

	/** Return an Iterator over the elements of this list. */
	@Override
	public Iterator<T> iterator() {
		return new SLListIterator();
	}

	/*********************/

	private class SLListIterator implements Iterator<T> {
		int n = 0; // point reached during enumeration

		public SLListIterator() {
		}

		public @Override boolean hasNext() {
			return n < size;
		}

		public @Override T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Node e = first;
			int k = 0;
			while (k < n) {
				e = e.next;
				k = k + 1;
			}
			n = n + 1;
			return e.value();
		}
	}
}
