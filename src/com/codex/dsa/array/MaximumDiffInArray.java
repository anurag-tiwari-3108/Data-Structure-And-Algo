package com.codex.dsa.array;
//Given an integer array, find the maximum difference between two elements in it such that the smaller element 

// appears before the larger element.

public class MaximumDiffInArray {

	public static void main(String[] args) {
		int[] ar = { 2, 7, 9, 5, 1, 3, 5 };

		System.out.println("Max Difference in array is ::  " + getMaxDiff(ar));

	}

	private static int getMaxDiff(int[] ar) {
		int diff = Integer.MIN_VALUE;
		int n = ar.length;
		if (n == 0) {
			return diff;
		}

		int max_so_far = ar[n - 1];

		for (int i = n - 2; i >= 0; i--) {

			if (ar[i] >= max_so_far) {
				max_so_far = ar[i];
			} else {
				diff = Integer.max(diff, max_so_far - ar[i]);
			}
		}

		return diff;
	}

}
