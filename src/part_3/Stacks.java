/**
 *
 */
package part_3;

/**
 * @author frankomullo
 *
 */
public class Stacks<T> implements Stack<T> {

	/**
	 *
	 */
	public static final int CAPACITY = 1000; // random capacity, though not necessary.
	private T[] stack;
	private int top = -1; // index of the top element in the stack

	public Stacks() {
		this(CAPACITY);
	}

	public Stacks(int capacity) {
		stack = (T[]) new Object[capacity];
	}

	/** Construct a stack with a given capacity */
	/**
	 * This array-based implementation has a constant running time of O(1) for all
	 * the methods implemented. space complexity is O(N)
	 */

	@Override
	public void push(T val) throws IllegalStateException {
		if (size() == stack.length)
			throw new IllegalStateException("Stack is full");
		stack[++top] = val; // increment t before storing a new item

	}

	@Override
	public T pop() {
		if (isEmpty())
			return null;
		T val = stack[top];
		stack[top] = null; // dereference to help garbage collection (learnt this in class.) this line can
							// be ommited without changing the complexity of the program
		top--;
		return val;

		// alternatively,
		// return stack[top--];
	}

	@Override
	public T top() {
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
