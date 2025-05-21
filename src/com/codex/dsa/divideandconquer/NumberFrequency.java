package com.codex.dsa.divideandconquer;

import java.util.HashMap;
import java.util.Map;

public class NumberFrequency {

	public static void main(String[] args) {
		int[] A = { 2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9 };

		// find the frequency of each array element and store it in a map
		Map<Integer, Integer> map = new HashMap<>();
		findFrequency(A, 0, A.length - 1, map);
		System.out.println(map);
	}

	private static void findFrequency(int[] A, int left, int right, Map<Integer, Integer> map) {
		if (left > right) {
			return;
		}
		if (A[left] == A[right]) {
			Integer count = map.get(A[left]);
			if (count == null) {
				count = 0;
			}
			map.put(A[left], count++);
			return;
		}
		
		int mid = (left + right)/2;
		findFrequency(A, left , mid, map);
		findFrequency(A, mid+1 , right, map);
	}

}
