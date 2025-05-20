package com.codex.dsa.array;

import java.util.Arrays;
import java.util.Random;

//Given an integer array, in-place shuffle it. The algorithm should produce an unbiased permutation, i.e., 
// every permutation is equally likely.

public class FisherYatesShuffle {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6 };

		shuffle(A);
		// print the shuffled array
		System.out.println(Arrays.toString(A));
	}

	private static void shuffle(int[] A) {
		for (int i = A.length - 1; i >= 1; i--) {
			Random rand = new Random();

			// generate a random number `j` such that `0 <= j <= i`
			int j = rand.nextInt(i + 1);

			// swap the current element with the randomly generated index
			swap(A, i, j);
		}

	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;

	}
}
