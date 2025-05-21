package com.codex.dsa.arrays;

// In-place merge two sorted array

// If X[i] is greater then Y[0] swap unless not
// if swap the value then update the new value in Y array to its correct position

public class MergeSortedArray {

	public static void main(String[] args) {
		int X[] = { 1, 4, 7, 8, 10 };
		int Y[] = { 2, 3, 9 };

		merge(X, Y);
		for (int i = 0; i < X.length; i++) {
			System.out.print(" " + X[i]);
		}
	}

	private static void merge(int[] X, int[] Y) {

		int m = X.length;
		int n = Y.length;

		for (int i = 0; i < m; i++) {

			if (X[i] > Y[0]) {
				// swap
				int temp = X[i];
				X[i] = Y[0];
				Y[0] = temp;

				int first = Y[0];
				int k = 1;
				for (k = 1; k < n && Y[k] < first; k++) {
					Y[k - 1] = Y[k];
				}
				Y[k - 1] = first;
			}

		}

	}
}
