package com.codex.dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class StackFromArray {
	List stack = new ArrayList();
	int max_size = 100;
	int top = -1;

	public void push(int element) {
		if (stack.size() > max_size) {
			System.out.println("Stack Overflow Exception");
			return;
		} else {
			stack.add(element);
		}
	}

	public int pop() {
		int popped = Integer.MIN_VALUE;
		if (stack.size() < 0) {
			System.out.println("Stack Underflow Exception");
		} else {
			popped = (Integer) stack.get(top--);
		}
		return popped;
	}

	public int peek() {
		int peeked = Integer.MIN_VALUE;
		if (stack.size() < 0) {
			System.out.println("Stack Underflow Exception");
		} else {
			peeked = (Integer) stack.get(top);
		}
		return peeked;
	}
}
