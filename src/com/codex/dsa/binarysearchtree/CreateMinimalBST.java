package com.codex.dsa.binarysearchtree;

import com.codex.dsa.binarysearchtree.Node;

// Create a BST from sorted increasing order array with minimal hieght
public class CreateMinimalBST {

	public static Node createBSTFromArray(int[] ar) {
		if (ar.length == 0) {
			return new Node(0);
		}
		return createBSTFromArray(ar, 0, ar.length - 1);
	}

	private static Node createBSTFromArray(int[] ar, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node node = new Node(ar[mid]);

		node.left = createBSTFromArray(ar, start, mid - 1);
		node.right = createBSTFromArray(ar, mid + 1, end);
		return node;
	}
}
