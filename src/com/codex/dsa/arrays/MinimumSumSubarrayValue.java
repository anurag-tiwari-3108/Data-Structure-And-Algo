package com.codex.dsa.arrays;

/**
 * https://www.techiedelight.com/find-subarray-having-given-sum-given-array/
 * 
 * @author anutiwar
 *
 */
public class MinimumSumSubarrayValue {
	public static void main(String[] args) {
		// an integer array
		int[] A = { 0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10 };
		int target = -3;

		if (findSubarray(A, target)) {
			System.out.print("Subarray with the given sum exists");
		} else {
			System.out.print("Subarray with the given sum does not exist");
		}
	}

	private static boolean findSubarray(int[] a, int target) {

		int window_sum = 0;
		int high = 0;
		for (int i = 0; i < a.length; i++) {
			while (window_sum < target && high < a.length) {
				window_sum += a[high];
				high++;
			}

			if (window_sum == target) {
                System.out.printf("Subarray found [%d–%d]", i, high - 1);
				return true;
			}
			window_sum -= a[i];
		}
		return false;
	}
}
