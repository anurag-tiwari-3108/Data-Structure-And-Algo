package com.codex.dsa.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		List<String> response = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}
		
		
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
       );

        for(Entry<String, Integer> entry: map.entrySet()) {
        	pq.offer(entry);
        	if(pq.size() >k) {
        		pq.poll();
        	}
        }
        
        while(!pq.isEmpty()) {
        	response.add(0,pq.poll().getKey());
        }
		return response;
	}

}
