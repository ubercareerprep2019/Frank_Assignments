package part_3;

import org.junit.jupiter.api.Test;

class StacksTest {

	@Test
	void teststacksPush() {
		Stack<Integer> stack = new Stacks<>();
		stack.push(5);
		stack.push(0);
		stack.push(700);
		System.out.println(stack.size()); // 3
		System.out.println(stack.pop()); // 700
		System.out.println(stack.isEmpty()); // false

	}

}
