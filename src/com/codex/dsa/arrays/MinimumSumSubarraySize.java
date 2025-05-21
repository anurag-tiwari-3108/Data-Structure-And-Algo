package com.codex.dsa.arrays;

/**
 * https://www.techiedelight.com/find-minimum-sum-subarray-given-size-k/
 * 
 * @author anutiwar
 *
 */
public class MinimumSumSubarraySize {

	public static void main(String[] args) {
		int[] arr = { 10, 4, 2, 5, 6, 3, 8, 1 };
		int k = 3;

		findSubarray(arr, k);
	}

	private static void findSubarray(int[] arr, int k) {
		if (arr.length == 0 || arr.length <= k) {
			System.out.println("No Combination Found");
			return;
		}
		int last = 0;
		int min_window_sum = Integer.MAX_VALUE;
		int window_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			window_sum += arr[i];

			if (i + 1 >= k) {
				if (min_window_sum > window_sum) {
					min_window_sum = window_sum;
					last = i;
				}
				window_sum -= arr[i + 1 - k];
			}
		}
		System.out.printf("The minimum sum subarray is (%d, %d)", last - k + 1, last);
	}
}
