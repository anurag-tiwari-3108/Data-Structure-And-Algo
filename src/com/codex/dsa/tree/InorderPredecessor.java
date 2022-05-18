package com.codex.dsa.tree;

public class InorderPredecessor {
	public static Node getInorderPredecessor(Node root, int key) {
		return getInorderPredecessor(root, null, key);
	}

	public static Node getInorderPredecessor(Node root, Node prev, int key) {
		if (root == null) {
			return prev;
		}
		if (root.data == key) {
			if (root.left != null) {
				return findMaximum(root.left);
			}

			else if (key < root.data) {
				return getInorderPredecessor(root.left, prev, key);
			} else {
				prev = root;
				return getInorderPredecessor(root.right, prev, key);
			}
		}

		return prev;
	}

	public static Node findMaximum(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}
}
