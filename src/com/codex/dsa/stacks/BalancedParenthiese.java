package com.codex.dsa.stacks;

import java.util.Stack;

public class BalancedParenthiese {


	public static void main(String[] args) {
		System.out.println("Balanced Brackets ?? :: "+simplifyPath("[({)}]"));
	}

	public static boolean simplifyPath(String A) {
		if (A.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < A.length(); i++) {
			char current = A.charAt(i);
			if (current == '(' || current == '{' || current == '[') {
				stack.push(current);
			} else if (current == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (current == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else if (current == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
