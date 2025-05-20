package com.codex.dsa.array;

import java.util.HashSet;
import java.util.Set;

// Sliding Window Based Algo
// Validate if duplicate is present in given limit of element

public class HasDuplicateSlidingWindow {
	public static void main(String[] args) {
		int[] arr = { 5, 6, 8, 2, 4, 6, 9 };
		int k = 4;
		System.out.println("Has Duplicate " + hasDuplicate(arr, k));
	}

	private static boolean hasDuplicate(int[] arr, int limit) {
		Set<Integer> window = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (window.contains(arr[i])) {
				return true;
			}
			window.add(arr[i]);
			if (i >= limit) {
				window.remove(i - limit);
			}
		}
		return true;
	}
}
