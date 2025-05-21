package com.codex.dsa.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintCombination {

	public static void main(String[] args) {
		int n = 5;
		int[] out = new int[n];

		// print all combinations of numbers from 1 to `n` having sum `n`
		backtrack(1, n, out, 0);
	}

	private static void backtrack(int start, int target, int[] out, int index) {
		// if the sum becomes `n`, print the combination
		if (target == 0) {
			System.out.println(Arrays.stream(out).limit(index).boxed().collect(Collectors.toList()));
		}

		// start from the previous element in the combination till `n`
		for (int i = start; i <= target; i++) {
			// place current element at the current index
			out[index] = i;

			// recur with a reduced sum
			backtrack(i, target - i, out, index + 1);
		}
	}
}
