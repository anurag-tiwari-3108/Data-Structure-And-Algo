package com.codex.dsa.strings;

import java.util.Arrays;
import java.util.List;

/**
 * Longest Common Prefix or LCP is the prefix present in all the strings of list
 * 
 * @author anutiwar
 *
 */
public class LCP {

	// Function to find the longest common prefix between two strings
	public static String getLCP(String X, String Y) {
		int i = 0, j = 0;
		while (i < X.length() && j < Y.length()) {
			if (X.charAt(i) != Y.charAt(j)) {
				break;
			}

			i++;
			j++;
		}

		return X.substring(0, i);
	}

	// A recursive function to find the longest common prefix (LCP) between a
	// given set of strings
	public static String findLCP(List<String> words, int low, int high) {
		// base case: if `low` is more than `high`, return an empty string
		if (low > high) {
			return "";
		}

		// base case: if `low` is equal to `high`, return the current string
		if (low == high) {
			return words.get(low);
		}

		// find the mid-index
		int mid = (low + high) / 2;

		// partition the problem into subproblems and recur for each subproblem
		String X = findLCP(words, low, mid);
		String Y = findLCP(words, mid + 1, high);
		
		System.out.println("X is "+X+" & Y is "+Y);

		// return the longest common prefix of strings `X` and `Y`
		return getLCP(X, Y);
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("techie delight", "tech", "techie", "technology", "technical");
		System.out.print("The longest common prefix is " + findLCP(words, 0, words.size() - 1));
	}

}
