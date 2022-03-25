package com.codex.dsa.stack;

import java.util.Stack;

/**
 * Example: { { } { } } – Well formed { { } { = Not well formed
 * 
 * @author anutiwar
 *
 */
public class WellFormedParentheses {

	public static void main(String[] args) {
		System.out.println("isWellFormedParentheses :: " + isWellFormedParentheses("{{}}"));
		System.out.println("isBalancedParentheses :: " + isBalancedParentheses("()({])"));
	}

	/*
	 * Applicable if the bracket type is same but if we get mix type of bracket then
	 * this method will not work
	 */
	public static boolean isWellFormedParentheses(String str) {
		char[] ar = str.toCharArray();
		int openParenthesesCount = 0;
		int closeParenthesesCount = 0;
		for (int i = 0; i < ar.length; i++) {
			char key = ar[i];
			if (key == '{') {
				openParenthesesCount++;
			} else if (key == '}') {
				closeParenthesesCount++;
			}

		}
		if (openParenthesesCount == closeParenthesesCount) {
			return true;
		}
		return false;
	}

	/*
	 * Applicable for all the types of parentheses
	 */
	public static boolean isBalancedParentheses(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char expression = str.toCharArray()[i];
			if (expression == '(' || expression == '{' || expression == '[') {
				stack.push(expression);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}
			char x = stack.peek();
			if (expression == ')') {
				if (x == '{' || x == '[') {
					return false;
				}
				stack.pop();
			}

			if (expression == '}') {
				if (x == '[' || x == '(') {
					return false;
				}
				stack.pop();
			}

			if (expression == ']') {
				if (x == '(' || x == '{') {
					return false;
				}
				stack.pop();
			}

		}

		return stack.isEmpty();

	}
}
