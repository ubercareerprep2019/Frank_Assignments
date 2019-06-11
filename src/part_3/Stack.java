package part_3;

/**
 * An interface which describes the methods of the stack ADT, their declarations
 * and use The stack is a container of objects that are inserted and removed
 * according to the Last-In-First-Out-Principle
 */

public interface Stack<T> {
	/**
	 * Pushes an element onto the top of the stack
	 *
	 * @param e, the element to be inserted
	 */
	void push(T e);

	/**
	 * Removes the element on top of the stack, and returns that value to the caller
	 *
	 * @return element removed, or null if empty
	 */

	T pop();

	/**
	 * Looks at the element at the top of the stack and returns it without
	 * manipulating the stack
	 *
	 * @return top element on the stack, null if empty
	 */

	T top();

	/**
	 * checks whether the stack is empty
	 *
	 * @return true if stack is empty, false otherwise
	 */
	boolean isEmpty();

	// this is just an additional helper function, not required in the assignment
	// documentation
	/**
	 * returns the number of elements in the stack
	 *
	 * @return number of elements in the stack
	 */
	int size();
}
