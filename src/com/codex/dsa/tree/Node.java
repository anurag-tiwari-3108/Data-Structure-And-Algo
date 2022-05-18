package com.codex.dsa.tree;

public class Node {
	public int data;
	public int hd;
	public  Node left, right;

	public Node(int item) {
		this.data = item;
		left = right = null;
	}

	public Node(int key, int hd) {
		data = key;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}

	public static Node getRandomBinaryTree() {
		Node tree = new Node(10);
		tree.left = new Node(2);
		tree.right = new Node(3);
		tree.left.left = new Node(7);
		tree.left.right = new Node(8);
		tree.right.right = new Node(15);
		tree.right.left = new Node(12);
		tree.right.right.left = new Node(14);

		return tree;
	}

	public static void printPreOrderRecursive(Node root) {
		// Root ->Left -> Right
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printPreOrderRecursive(root.left);
		printPreOrderRecursive(root.right);
	}

	public static void printPostOrderRecursive(Node root) {
		// Left -> Right -> Root
		if (root == null) {
			return;
		}
		printPostOrderRecursive(root.left);
		printPostOrderRecursive(root.right);
		System.out.print(root.data + " ");
	}

	public static void printInOrderRecursive(Node root) {
		if (root == null) {
			return;
		}
		printInOrderRecursive(root.left);
		System.out.print(root.data + " ");
		printInOrderRecursive(root.right);
	}

	public static void printPreOrderIteratively(Node root) {
	}

	public static void printPostOrderIteratively(Node root) {

	}

	public static void printInOrderIteratively(Node root) {

	}
}
