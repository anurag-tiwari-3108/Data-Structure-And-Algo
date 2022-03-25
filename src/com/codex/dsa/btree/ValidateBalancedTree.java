package com.codex.dsa.btree;

public class ValidateBalancedTree {
	public static boolean isValidBalancedTree(Node root) {
		if (root == null) {
			return true;
		}
		int heightDifference = getTreeHeight(root.left) - getTreeHeight(root.right);
		if (Math.abs(heightDifference) > 1) {
			return false;
		} else {
			return isValidBalancedTree(root.left) && isValidBalancedTree(root.right);
		}
	}
	private static int getTreeHeight(Node root) {
		if (root == null)
			return 0;
		return (1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right)));
	}
}
