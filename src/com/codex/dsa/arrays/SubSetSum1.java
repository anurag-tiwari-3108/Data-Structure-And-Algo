package com.codex.dsa.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// time 2^n + n
// space O(N)

public class SubSetSum1 {

	private List<Integer> subsetSumList(List list) {
		List<Integer> subsetSum = new ArrayList<>();
		subsetSumList(0, 0, new ArrayList<Integer>(), list.size(), new ArrayList<Integer>());
		Collections.sort(subsetSum);
		return subsetSum;
	}

	private void subsetSumList(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> subsetSum) {

		if (ind == N) {
			subsetSum.add(sum);
			return;
		}

		// pick the element

		subsetSumList(ind + 1, sum + arr.get(ind), arr, N, subsetSum);

		// not pick the element

		subsetSumList(ind + 1, sum, arr, N, subsetSum);

	}

}
