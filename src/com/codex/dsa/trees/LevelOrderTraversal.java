package com.codex.dsa.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LevelOrderTraversal {

	public static List<List<Integer>> levelOrderUsingMap(Node node) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		helper(node, map, 0);
		return new ArrayList<>(map.values());
	}

	public static void levelOrderUsingQueue(Node root)
	    {
	        // base case
	        if (root == null) {
	            return;
	        }
	 
	        // create an empty queue and enqueue the root node
	        Queue<Node> queue = new ArrayDeque<>();
	        queue.add(root);
	 
	        // to store the current node
	        Node curr;
	 
	        // loop till queue is empty
	        while (!queue.isEmpty())
	        {
	            // process each node in the queue and enqueue their
	            // non-empty left and right child
	            curr = queue.poll();
	 
	            System.out.print(curr.data + " ");
	 
	            if (curr.left != null) {
	                queue.add(curr.left);
	            }
	 
	            if (curr.right != null) {
	                queue.add(curr.right);
	            }
	        }
	    }
	

	private static void helper(Node node, Map<Integer, List<Integer>> map, Integer level) {
		// base case
		if (node == null)
			return;

		if (map.containsKey(level)) {
			map.get(level).add(node.data);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(node.data);
			map.put(level, list);
		}

		// iterate for left & right subtree

		helper(node.left, map, level + 1);
		helper(node.right, map, level + 1);

	}
}
