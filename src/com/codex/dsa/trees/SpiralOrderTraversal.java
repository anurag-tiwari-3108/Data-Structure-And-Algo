package com.codex.dsa.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 3 Ways to achieve this 1) MultiMap which contains Level as key and List of
 * element of that level as value. If the level is odd will add in Last or add
 * in First of list. Extra space but time O(n) 2) Write 2 method to
 * printLeftToRight and printRightToLeft. Constant Space but Time O(N^2) 3)
 * Maintain a queue and iterate this as per constraints
 * 
 * 
 * @author anutiwar
 *
 */
public class SpiralOrderTraversal {
	public static void main(String[] args) {
		Node node = Node.getRandomBinaryTree();
		Node.printPreOrderRecursive(node);
		System.out.println();
		printSprialOrderTraversal(node);
		System.out.println();
		printSprialOrderMap(node);

	}

	// Solution-1
	private static void printSprialOrderMap(Node root) {
		// create an empty map to store nodes between given levels
		Map<Integer, Deque<Integer>> map = new HashMap<>();

		// traverse the tree and insert its nodes into the map
		// corresponding to their level
		preorder(root, 1, map);

		// iterate through the map and print all nodes present at every level
		for (int i = 1; i <= map.size(); i++) {
			System.out.println("Level " + i + ": " + map.get(i));
		}
	}

	public static void preorder(Node root, int level, Map<Integer, Deque<Integer>> map) {
		// base case: empty tree
		if (root == null) {
			return;
		}

		// insert the current node and its level into the map
		map.putIfAbsent(level, new ArrayDeque<>());

		// if the level is odd, insert at the back; otherwise, search at front
		if (level % 2 == 1) {
			map.get(level).addLast(root.data);
		} else {
			map.get(level).addFirst(root.data);
		}

		// recur for the left and right subtree by increasing the level by 1
		preorder(root.left, level + 1, map);
		preorder(root.right, level + 1, map);
	}

	// Solution-2
	private static void printSprialOrderTraversal(Node node) {
		if (node == null) {
			return;
		}
		int level = 1;
		while (printLevelLeftToRight(node, level++) && printLevelRightToLeft(node, level++))
			;
	}

	private static boolean printLevelRightToLeft(Node root, int level) {
		if (root == null) {
			return false;
		}

		if (level == 1) {
			System.out.print(root.data + " ");
			return true;
		}

		// process right child before the left child
		boolean right = printLevelRightToLeft(root.right, level - 1);
		boolean left = printLevelRightToLeft(root.left, level - 1);

		return right || left;
	}

	private static boolean printLevelLeftToRight(Node root, int level) {

		if (root == null) {
			return false;
		}

		if (level == 1) {
			System.out.print(root.data + " ");
			return true;
		}

		// process left child before the right child
		boolean left = printLevelLeftToRight(root.left, level - 1);
		boolean right = printLevelLeftToRight(root.right, level - 1);

		return left || right;
	}

}
