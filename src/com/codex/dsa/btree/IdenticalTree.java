package com.codex.dsa.btree;

public class IdenticalTree {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(12);
		root.left.left = new Node(13);
		root.right.right = new Node(14);
		root.left.left.left = new Node(15);
		root.right.right.right = new Node(16);

		Node root2 = new Node(10);
		root2.left = new Node(11);
		root2.right = new Node(12);
		root2.left.left = new Node(13);
		root2.right.right = new Node(14);
		root2.left.left.left = new Node(15);
		root2.right.right.right = new Node(16);

		System.out.println("Are the two Trees Identicals ? " + isIdenticalTree(root, root2));
	}

	private static boolean isIdenticalTree(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 != null && root2 != null)
			return (root1.data == root2.data && isIdenticalTree(root1.left, root2.left)
					&& isIdenticalTree(root1.right, root2.right));

		return false;
	}
}
