package com.codex.dsa.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Remove All Duplicate from array
 * 
 * @author anutiwar
 *
 */
public class RemoveDuplicates {

	public static void main(String... args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		System.out.println("Remove Duplicate from Array List");
		removeDuplicate(list, list.size());
		list.stream().forEach(System.out::print);
		System.out.println();
		System.out.println("Remove Duplicate from Arrays");
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		removeDuplicate(arr, arr.length);
	}

	public static void removeDuplicate(int arr[], int n) {
		int idx = 0;
		int prev = Integer.MIN_VALUE;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1] && prev != arr[i]) {
				prev = arr[i];
				arr[idx] = arr[i];
				idx++;
			}
		}
		arr[idx++] = arr[n - 1];
		for (int i = 0; i < idx; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void removeDuplicate(List<Integer> list, int n) {
		int idx = 0;
		for (int element : list.stream().distinct().collect(Collectors.toList())) {
			if (list.get(idx) == element && list.get(idx + 1) == element) {
			}
		}
	}
}
