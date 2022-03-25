package com.codex.dsa.btree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class PrintBottomView {
	public static void main(String[] args) {
		Node tree = Node.getRandomBinaryTree();
		Map<Integer, Integer> map = new TreeMap<>();
		printBottonViewItr(tree, 0);
		printBottonViewRecursively(tree, 0, map);
	}

	// TODO - Need to correct this method
	public static void printBottonViewRecursively(Node root, int level, Map<Integer, Integer> map) {
		if (root == null) {
			return;
		}
		
		map.put(level, root.data);
		printBottonViewRecursively(root.left, level-1, map);
		printBottonViewRecursively(root.right, level+1, map);
		
	}

	public static void printBottonViewItr(Node root, int level) {
		if (root == null) {
			return;
		}
		// TreeMap which stores key value pair sorted on key value
		Map<Integer, Integer> map = new TreeMap<>();

		// Queue to store tree nodes in level order traversal
		Queue<Node> queue = new LinkedList<Node>();
		root.hd = level;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			level = temp.hd;

			map.put(level, temp.data);

			if (root.left != null) {
				root.left.hd = level - 1;
				queue.add(root.left);
			}
			if (root.right != null) {
				root.right.hd = level + 1;
				queue.add(root.right);
			}

			Set<Entry<Integer, Integer>> set = map.entrySet();

			// Make an iterator
			Iterator<Entry<Integer, Integer>> iterator = set.iterator();

			// Traverse the map elements using the iterator.
			while (iterator.hasNext()) {
				Map.Entry<Integer, Integer> me = iterator.next();
				System.out.print(me.getValue() + " ");
			}
		}

	}

}
