package com.codex.dsa.arrays;

import java.util.HashSet;

public class NumberOfSubarrayPair{

	public static void main(String[] args) {
		int[] arr = { 3, 4, -7, 1, 3, 3, 1, -4 };
        int sum = 7;
		System.out.println("Number of subarray pairs ");
		getNoOfPairs(arr, sum);
	}

	private static void getNoOfPairs(int[] arr, int sum) {
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];
//			System.out.println("Temp : "+temp+" Sum : "+sum+" ith : "+arr[i]);

			// checking for condition
			if (s.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			s.add(arr[i]);
		}
	}
}
