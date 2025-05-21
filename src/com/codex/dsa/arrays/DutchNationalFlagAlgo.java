package com.codex.dsa.arrays;

import java.util.Arrays;

public class DutchNationalFlagAlgo {

	public static void main(String[] args) {
		int[] arr = { 0, 2, 2, 1, 1, 1, 1, 2, 2, 0, 1, 0, 0, 0, 1 };
		sortArrayOf012(arr);

	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

	private static void sortArrayOf012(int[] arr) {
		
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;

		while (mid <= high) {
			if(arr[mid] == 0) {
				swap(arr, low,mid);
				low++;
				mid++;
			}
			if(arr[mid]==1) {
				mid++;
			}
			if(arr[mid]==2) {
				swap(arr,mid,high);
				high--;
			}
			
		}
			System.out.print(Arrays.toString(arr));
	}
}
