package com.codex.dsa.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubarraySumZero {

	public static void main(String[] args) {
		int [] arr = { 4, -6, 3, -1, 4, 2, 7 };
		int target = 0;
		getSubarrayWithGivenSum(arr, target);
	
		if(hasSubarrayWithGivenSum(arr)) {
			System.out.println("Techidelight Solution :: The subarray sum is available ");
		}
	}

	private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
		hashMap.putIfAbsent(key, new ArrayList<>());
		hashMap.get(key).add(value);
	}

	private static void getSubarrayWithGivenSum(int[] arr, int target) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int sum = 0;
		insert(map, 0, -1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				List<Integer> list = map.get(sum);
				for (Integer val : list) {
					System.out.println("Subarray Found at " + (val+1) + " and " + i);
				}
			}
			insert(map, sum, i);
		}
	}
	
	public static Boolean hasSubarrayWithGivenSum(int[] A)
    {
        // create an empty set to store the sum of elements of each
        // subarray `A[0…i]`, where `0 <= i < arr.length`
        Set<Integer> set = new HashSet<>();
 
        // insert 0 into the set to handle the case when subarray with
        // zero-sum starts from index 0
        set.add(0);
 
        int sum = 0;
 
        // traverse the given array
        for (int value: A)
        {
            // sum of elements so far
            sum += value;
 
            // if the sum is seen before, we have found a subarray with zero-sum
            if (set.contains(sum)) {
                return true;
            }
 
            // insert sum so far into the set
            set.add(sum);
        }
 
        // we reach here when no subarray with zero-sum exists
        return false;
    }
}
