package com.codex.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Subset Sum 1 prob with one additional condition to avoid any duplicate
// One things which we can do is to put the response into set but that will increase the time and space complexity

// We are following another approach here to avoid duplicate i.e sort the array and validate if current_val == current-1_val
public class SubsetSum2 {

	private void subsetSum(int[] arr, int N) {
		Arrays.sort(arr);
		List<List<Integer>> ans = new ArrayList<>();
		subsetSum(0, arr, new ArrayList<>(), ans);

	}

	private void subsetSum(int ind, int[] arr, List ds, List<List<Integer>> ans) {

		ans.add(new ArrayList<>(ds));
		for (int i = ind; i < arr.length; i++) {
			if (i != ind && arr[i] == arr[i - 1])
				continue;

			ds.add(arr[i]);
			subsetSum(ind + 1, arr, ds, ans);
			ds.remove(ds.size() - 1);

		}

	}

}
