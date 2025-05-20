package com.codex.dsa.dp;

/**
 * Given an array of pairs of numbers of size N. In every pair, the first number
 * is always smaller than the second number. A pair (c, d) can follow another
 * pair (a, b) if b < c. The chain of pairs can be formed in this fashion. The
 * task is to find the length of the longest chain which can be formed from a
 * given set of pairs.
 * 
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40},
 * {50, 90} }, then the longest chain that can be formed is of length 3, and the
 * chain is {{5, 24}, {27, 40}, {50, 90}}
 * 
 * @author anutiwar
 *
 *         Time complexity in case of DP - O(N*N) but in case of greedy algo the
 *         time complexity of O(NlogN)
 */
public class MaxLengthChain {
	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	};

	public static void main(String args[]) {

		// Declaration of array of structure
		Pair p[] = new Pair[5];

		p[0] = new Pair(5, 24);
		p[1] = new Pair(39, 60);
		p[2] = new Pair(15, 28);
		p[3] = new Pair(27, 40);
		p[4] = new Pair(50, 90);

		int n = p.length;

		System.out.println(maxChainLength(p, n));
	}

	private static int maxChainLength(Pair arr[], int n) {
		int i, j, max = 0;
		int mcl[] = new int[n];

		/*
		 * Initialize MCL (max chain length) values for all indexes
		 */
		for (i = 0; i < n; i++)
			mcl[i] = 1;

		/*
		 * Compute optimized chain length values in bottom up manner
		 */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i].first > arr[j].second && mcl[i] < mcl[j] + 1)
					mcl[i] = mcl[j] + 1;

		// mcl[i] now stores the maximum
		// chain length ending with pair i

		/* Pick maximum of all MCL values */
		for (i = 0; i < n; i++)
			if (max < mcl[i])
				max = mcl[i];

		return max;
	}
}