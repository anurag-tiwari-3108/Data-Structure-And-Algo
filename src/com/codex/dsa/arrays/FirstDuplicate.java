package com.codex.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate {
	
	public static void main(String[] args) {
		int[] ar = {1,2,3,2,1};
		System.out.println(firstDuplicateValueNoSpace(ar));
	}

	public static int firstDuplicateValue(int[] array){
		Set<Integer> seen = new HashSet<>();
		for (int num : array) {
			if (seen.contains(num)) return num;
			seen.add(num);
		}
		return -1;
	}

	public static  int firstDuplicateValueNoSpace(int[] array){
		for (int num : array){
			int absValue = Math.abs(num); //mark the index whose value is current num; this marks the num presence without using space
			System.out.println("absValue : "+absValue);
			if (array[absValue - 1] < 0) return absValue; //negative num indicates absValue is seen before bcoz its index is marked 
			array[absValue - 1] *= -1;
			System.out.println("array : "+Arrays.toString(array));
		}
		return -1;
	}
}
