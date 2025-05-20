package com.codex.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Approach - 1:
// 		1) Create a Frequency map and put the keySet into a priorityQueue(sorted in assendint order) i.e max heap;
//		2) Run a look for k times and return the values


// Approach - 2
//		1) Run the Bucket Sort over the array
//		2) Run a loop for k element and return the value

// Coding for Approach -2 Bucket Sort
public class TopKFrequentElement {
	
	public static void main(String [] args) {
		int[] ip = {1,1,1,2,2,3};
		topKFrequent(ip, 2);
	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
		
		List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        
        
        for(int n : nums) {
        	freq.put(n, freq.getOrDefault(n,0)+1);
        }
        for(int key : freq.keySet()) {
        	int frequency = freq.get(key);
        	if(bucket[frequency] == null) {
        		bucket[frequency] = new ArrayList<>();
        	}
        	bucket[frequency].add(key);
        }
        
        System.out.println(Arrays.toString(bucket));
        
        List<Integer> res = new ArrayList<>();
        
        for(int pos = bucket.length-1; pos >=0 && res.size()< k ; pos--) {
        	if(bucket[pos] != null) {
        		res.addAll(bucket[pos]);
        	}
        }
        
        System.out.println(res);

        return res;
	}

}
