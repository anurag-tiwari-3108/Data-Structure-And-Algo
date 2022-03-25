package com.codex.dsa.btree;

public class HeightOfTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(12);
		root.left.left = new Node(13);
		root.right.right = new Node(14);
		root.left.left.left = new Node(15);
		root.right.right.right = new Node(16);
		System.out.println("Height Of Binary Tree is " + getHeight(root));
	}

	public static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

}
