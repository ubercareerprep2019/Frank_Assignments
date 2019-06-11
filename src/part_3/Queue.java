package part_3;

public class Queue<Integer> {
	/**
	 * this implementation uses one stack and a recursive call stack. dequeue is a
	 * bit intensive:, pop all elements but one from the stack to the call stack we
	 * remove the last element and return it, then all the other elements are pushed
	 * back to the main stack at the end of the recursion
	 */
	private Stacks<Integer> stack;

	public Queue() {
		stack = new Stacks<>();

	}

	public <T> void enqueue(Integer val) {
		stack.push(val);
	}

	public Integer dequeue() {
		if (stack.isEmpty()) {
			System.out.println("Empty stack");
			return null;
		}
		Integer top = stack.pop();
		if (stack.isEmpty()) {
			return top;
		}

		Integer val = dequeue();
		stack.push(top);
		return val;

	}

	public int min() {
		return -1;
	}

	public static void main(String[] args) {
		int[] keys = { 5, 0, 700, 5, 0 };
		Queue q = new Queue();
		for (int key : keys) {
			q.enqueue(key);
		}

		System.out.println(q.dequeue()); // 5
		System.out.println(q.dequeue()); // 0
	}

}
