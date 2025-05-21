package com.codex.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 2, 1 };
		System.out.println("Shortest subarray length  "+findShortestSubArray(nums));
	}

	public static int findShortestSubArray(int[] nums) {
		if (nums.length <= 0) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		;
		int degree = Integer.MIN_VALUE;
		Map<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new int[] { 1, i, i });
			} else {
				int temp[] = map.get(nums[i]);
				temp[0]++;
				temp[2] = i;
			}
		}
		for (int[] value : map.values()) {
			if (value[0] > degree) {
				degree = value[0];
				res = value[2] - value[1] + 1;
			} else if (value[0] == degree) {
				res = Math.min(value[2] - value[1] + 1, res);
			}
		}
		return res;
	}
}
