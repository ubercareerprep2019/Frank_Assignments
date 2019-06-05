/**
 *
 */
package part_3;

/**
 * @author frankomullo
 *
 */
public class Stacks<E> implements Stack<E> {

	/**
	 *
	 */
	public static final int CAPACITY = 1000;
	private E[] stack;
	private int top = -1; // index of the top element in the stack

	public Stacks() {
		this(CAPACITY);
	}

	public Stacks(int capacity) {
		stack = (E[]) new Object[capacity];
	}

	/** Construct a stack with a given capacity */
	/**
	 * This array-based implementation has a constant running time of O(1) for all
	 * the methods implemented. space complexity is O(N)
	 */

	@Override
	public void push(E e) throws IllegalStateException {
		if (size() == stack.length)
			throw new IllegalStateException("Stack is full");
		stack[++top] = e; // increment t before storing a new item

	}

	@Override
	public E pop() {
		if (isEmpty())
			return null;
		E val = stack[top];
		stack[top] = null; // dereference to help garbage collection (learnt this in class.) this line can
							// be ommited without changing the complexity of the program
		top--;
		return val;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return stack[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public int size() {
		return top + 1;
	}

}
