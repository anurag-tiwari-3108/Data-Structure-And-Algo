package com.codex.dsa.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalView {

	public static void printVerticalView(Node root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		printVerticalView(root, map, 0);
	}

	private static void printVerticalView(Node root, Map<Integer, List<Integer>> map, int level) {
		
		if(root == null) {
			return;
		}
		
		insertIntoMultiMap(map,root.data, level);
		
		printVerticalView(root.left, map, level-1);
		
		printVerticalView(root.right, map, level+1);
		
	}

		public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,Integer key, Integer value) {
				map.putIfAbsent(key, new ArrayList<>());
				map.get(key).add(value);
	}
}
