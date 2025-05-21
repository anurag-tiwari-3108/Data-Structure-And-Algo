package com.codex.dsa.binarysearchtree;

import com.codex.dsa.binarysearchtree.Node;

public class BuildBSTFromPreorder {
	/** preorder = root->left->right **/

	public static Node node;

	public static void main(String[] args) {
		int[] ar = { 15, 10, 8, 12, 20, 16, 25 };
		Node node = new Node(ar[0]);
		for (int i = 1; i < ar.length - 1; i++) {
			create(ar[i]);
		}
		inorder(node);
	}

	public static void create(int data) {
		node = createNode(node, data);
	}

	public static Node createNode(Node node, int data) {
		if (node == null)
			node = new Node(data);

		if (node.data > data)
			node.left = createNode(node.left, data);
		if (node.data < data)
			node.right = createNode(node.right, data);

		return node;
	}

	private static void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}
}
