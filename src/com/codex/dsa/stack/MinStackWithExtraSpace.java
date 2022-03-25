package com.codex.dsa.stack;

import java.util.Stack;

public class MinStackWithExtraSpace {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> min_stack = new Stack<Integer>();

	public void push(int val) {
		if (val < min_stack.peek()) {
			min_stack.push(val);
		}
		stack.push(val);
	}

	public int pop() {
		if (stack.isEmpty()) {
			return 0;
		}
		int pop_val = stack.pop();
		if (pop_val == min_stack.peek()) {
			min_stack.pop();
		}
		return pop_val;
	}

	public int top() {
		if (stack.isEmpty()) {
			return 0;
		}
		return stack.peek();
	}

	public int getMin() {
		if (min_stack.isEmpty()) {
			return 0;
		}
		return min_stack.peek();
	}

}
