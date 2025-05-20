package com.codex.dsa.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Find al the distinct Combination subarray of array with length k 
// https://www.techiedelight.com/find-distinct-combinations-given-length-2/


public class DistinctCombination {

	public static void main(String[] args) {
		int[] ar = { 2,3,4 };
		int k = 2;
		Set<List<Integer>> subarrays = new HashSet<>();
		System.out.println("" + findCombinations(ar, 0, k, subarrays, new ArrayList<>()));
	}

	private static Set<List<Integer>> findCombinations(int[] A, int start, int k, Set<List<Integer>> subarrays,
			List<Integer> out) {

		if (A.length == 0) {
			return subarrays;
		}
		if (k == 0) {
			subarrays.add(new ArrayList<>(out));
			return subarrays;
		}

		if (start == A.length) {
			return subarrays;
		}

		out.add((A[start]));
		findCombinations(A, start + 1, k - 1, subarrays, out);
		out.remove(out.size() - 1);
		return findCombinations(A, start + 1, k, subarrays, out);
	}

}
