package com.codex.dsa.array;

/**
 * walmart labs murugan.sundararaj@walmartlabs.com
 * 
 * @author anutiwar
 * 
 *         Find the maximum sequence of continuous 1’s formed by replacing
 *         at-most `k` zeroes by ones
 * 
 * https://www.techiedelight.com/find-maximum-sequence-of-continuous-1s-can-formed-replacing-k-zeroes-ones/
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		MaxConsecutiveOnes ones = new MaxConsecutiveOnes();
		int maxFlip = 2;
		int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		System.out.println("Max Consecutive Ones are : " + ones.maxOnes(arr, maxFlip));
		System.out.println("Max Consecutive Ones(Method 2) are : " + ones.maxOnes_method2(arr, maxFlip));
	}

	private String maxOnes_method2(int[] arr, int maxFlip) {
		// the idea is to maintain sliding window and shift the window which at most
		// contain k zeros.

		int left = 0;
		int count = 0;
		int window = 0;

		int leftIndex = 0;

		for (int right = 0; right < arr.length; right++) {

			if (arr[right] == 0) {
				count++;
			}

			while (count > maxFlip) {
				if (arr[left] == 0) {
					count--;
				}

				left++;

			}
			if (right - left + 1 > window) {
				window = right - left + 1;
				leftIndex = left;
			}
			System.out.println("The longest sequence has length " + window + " from index " + leftIndex + " to "
					+ (leftIndex + window - 1));
		}

		return null;
	}

	public int maxOnes(int[] arr, int K) {
		int max = 0;
		int zeroCount = 0;
		int id = 0;
		for (int j = 0; j < arr.length; ++j) {
			if (arr[j] == 0) { // move forward j, if current is 0, increase the zeroCount
				zeroCount++;
			}
			System.out.println("Current ZeroCount A " + zeroCount + "  J: " + arr[j]);
			// when current window has more than K, the window is not valid any more
			// we need to loop the slow pointer until the current window is valid
			while (zeroCount > K) {
				if (arr[id] == 0) {
					zeroCount--;
				}
				id++;
			}
			System.out.println("Current ZeroCount B " + zeroCount + " Max " + max);
			max = Math.max(max, j - id + 1); // Every time we get here, the current window is valid
		}
		return max;
	}
}
