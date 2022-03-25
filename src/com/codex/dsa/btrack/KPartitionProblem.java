package com.codex.dsa.btrack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Need to Partition the array in k parts such that every part is having same
 * sum or values or number of element
 * 
 * @author anutiwar
 *
 */
public class KPartitionProblem {
	static int[] S;
	static int K = 5;

	public static void main(String[] args) {
		S = new int[] { 7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4 };
		printAllPartitions();
	}

	private static void printAllPartitions() {

		int len = S.length;
		// K = Number of Partitions
		if (len < K) {
			System.out.println("k-partition of set S is not possible");
			return;
		}

		int sum = IntStream.of(S).sum();
		int[] A = new int[len];
		int[] sumLeft = new int[K];

		Arrays.fill(sumLeft, sum / K);

		// return true if the sum is divisible by `k` and set `S` can be divided into  `k` subsets with equal sum
		boolean result = (sum % K) == 0 && subsetSum(S, len - 1, sumLeft, A, K);

		if (!result) {
			System.out.println("k-partition of set S is not possible");
			return;
		}

		printAllPartitionsData(len, A);

	}

	private static void printAllPartitionsData(int len, int[] A) {
		for (int i = 0; i < K; i++) {
			System.out.print("Partition " + i + " is ");
			for (int j = 0; j < len; j++) {
				if (A[j] == i + 1) {
					System.out.print(S[j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static boolean checkSum(int[] sumLeft, int k) {
		for (int i = 0; i < k; i++) {
			if (sumLeft[i] != 0) {
				return false;
			}
		}

		return true;
	}

	private static boolean subsetSum(int[] S, int n, int[] sumLeft, int[] A, int k) {
		// return true if a subset is found
		if (checkSum(sumLeft, k)) {
			return true;
		}
		// base case: no items left
		if (n < 0) {
			return false;
		}
		boolean result = false;

		// consider current item `S[n]` and explore all possibilities using backtracking
		for (int i = 0; i < k; i++) {
			if (!result && (sumLeft[i] - S[n]) >= 0) {
				// mark the current element subset
				A[n] = i + 1;

				// add the current item to the i'th subset
				sumLeft[i] = sumLeft[i] - S[n];

				// recur for remaining items
				result = subsetSum(S, n - 1, sumLeft, A, k);

				// backtrack: remove the current item from the i'th subset
				sumLeft[i] = sumLeft[i] + S[n];
			}
		}

		// return true if we get a solution
		return result;
	}

}
