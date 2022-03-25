package com.codex.dsa.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubarraySumK {

	public static void main(String[] args) {
		int[] arr = { 3, 4, -7, 1, 3, 3, 1, -4 };
		int sum = 7;
		getSubarrayWithSumK(arr, sum);
	}

	private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
		hashMap.putIfAbsent(key, new ArrayList<>());
		hashMap.get(key).add(value);
	}

	public static void printSubarray(int[] A, int i, int j) {
		System.out.println(IntStream.range(i, j + 1).mapToObj(k -> A[k]).collect(Collectors.toList()));
	}

	private static void getSubarrayWithSumK(int[] arr, int target) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		insert(map, 0, -1);
		int sum_so_far = 0;

		for (int index = 0; index < arr.length; index++) {
			sum_so_far = sum_so_far + arr[index];

			if (map.containsKey(sum_so_far - target)) {
				List<Integer> list = map.get(sum_so_far - target);
				for (Integer element : list) {
					printSubarray(arr, element + 1, index);
				}

			}
			insert(map, sum_so_far, index);
		}

	}

}
