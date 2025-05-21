package com.codex.dsa.binarysearchtree;

import com.codex.dsa.binarysearchtree.Node;

public class BSTCRUDOperations {
	public static Node deleteNodeFromBST(Node root, int key) {
		Node parent = null;
		Node curr = root;
		// Finding the key and storing its parent
		while (curr != null && curr.data != key) {
			parent = curr;
			if (key < curr.data) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		if (curr == null) {
			return root;
		}

		if (curr.left == null && curr.right == null) {
			if (curr != root) {
				if (parent.left == curr) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else {
				root = null;
			}
		} else if (curr.left != null && curr.right != null) {
			Node successor = getMinimumKey(curr.right);
			int val = successor.data;
			deleteNodeFromBST(root, successor.data);
			curr.data = val;
		} else {
			Node child = (curr.left != null) ? curr.left : curr.right;
			if (curr != root) {
				if (curr == parent.left) {
					parent.left = child;
				} else {
					parent.right = child;
				}
			} else {
				root = child;
			}
		}
		return root;
	}

	public static Node getMinimumKey(Node curr) {
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	public static Node insertNodeFromBST(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.data) {
			root.left = insertNodeFromBST(root.left, key);
		} else {
			root.right = insertNodeFromBST(root.right, key);
		}

		return root;
	}

}
