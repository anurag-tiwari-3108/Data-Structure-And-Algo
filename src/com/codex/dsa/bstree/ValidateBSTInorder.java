package com.codex.dsa.bstree;

import com.codex.dsa.btree.Node;

public class ValidateBSTInorder {
	static Node prev;

	// Basic approach  but doesn't work in many cases
	public static boolean validateBST(Node root) {
		// Valid but not an correct method to validate, As it will failed in some case
		if (root == null) {
			return true;
		}

		validateBST(root.left);
		validateBST(root.right);		

		if (root.left != null && root.data > root.left.data && root.right != null && root.data < root.right.data) {
			return true;
		}

		return false;
	}

	public static boolean validateBSTEfficient(Node root) {
		return isBSTUtil(root);
	}
	public static boolean isBSTUtil(Node root) {
		if (root != null) {
			if (!isBSTUtil(root.left)) {
				return false;
			}
			if (prev != null && root.data <= prev.data)
				return false;
			prev = root;

			return isBSTUtil(root.right);
		}

		return true;
	}

	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.left.left = new Node(5);
		root.left = new Node(14);
		root.right = new Node(20);
		root.right.left = new Node(17);
		root.right = new Node(25);
		System.out.println("isBST :: " + validateBSTEfficient(root));
	}

}
