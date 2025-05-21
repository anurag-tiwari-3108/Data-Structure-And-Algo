package com.codex.dsa.trees;

/**
 * Single class to handle insert/travesal/search/all_types_of_delete operations
 * of BST 50 / \ 30 70 / \ / \ 20 40 60 80
 * 
 * @author anutiwar
 *
 */
public class InsertDeleteBSTNode {
	Node root;

	public static void main(String[] args) {
		InsertDeleteBSTNode BSTree = new InsertDeleteBSTNode();
		BSTree.insert(50);
		BSTree.insert(30);
		BSTree.insert(20);
		BSTree.insert(40);
		BSTree.insert(70);
		BSTree.insert(60);
		BSTree.insert(80);
		BSTree.inorderTravesal();
		BSTree.deleteNode(20); // case -1- Node without child
		BSTree.inorderTravesal();
		BSTree.deleteNode(30); // case -2- Node with 1child
		BSTree.inorderTravesal();
		BSTree.deleteNode(50); // case -3- Node with 2 child
		BSTree.inorderTravesal();
	}

	private void deleteNode(int key) {
		System.out.println("\nGoind go to delete node : " + key);
		root = recursiveDeleteNode(root, key);
	}

	private Node recursiveDeleteNode(Node root, int key) {
		if (root == null) {
			return root;
		}
		if (key < root.key) {
			root.left = recursiveDeleteNode(root.left, key);
		} else if (key > root.key) {
			root.right = recursiveDeleteNode(root.right, key);
		} else {
			// for node with 1 or no child
			if (root.left == null) {
				return root.left;
			} else if (root.right == null) {
				return root.right;
			}

			// for node with 2 child in that case the right side child would be the root
			root.key = getMinimumValue(root.right);
			root.right = recursiveDeleteNode(root.right, root.key);
		}
		return root;
	}

	private int getMinimumValue(Node root) {
		int min_value = root.key;
		while (root.left != null) {
			min_value = root.left.key;
			root = root.left;
		}
		return min_value;
	}

	private void inorderTravesal() {
		recursiveInorderTravesal(root);
	}

	private void recursiveInorderTravesal(Node root) {
		if (root != null) {
			recursiveInorderTravesal(root.left);
			recursiveInorderTravesal(root.right);
		}

	}

	private void insert(int key) {
		root = insertRecursive(root, key);
	}

	private Node insertRecursive(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key) {
			root.left = insertRecursive(root.left, key);
		} else {
			root.right = insertRecursive(root.right, key);
		}

		return root;
	}

	private int recursiveFindLCA(Node root, int A, int B) {
		if (root == null) {
			return root.key;
		}
		if (root.key > A && root.key > B) {
			recursiveFindLCA(root.left, A, B);

		}
		if (root.key < A && root.key < B) {
			recursiveFindLCA(root.right, A, B);
		}
		return root.key;
	}
	
	private int iterativelyFindLCA(Node root, int A, int B) {
		// Store path from root to A and root to B in an array and the iteratively check
		// the common param in both the arrays
		return root.key;
	}

	class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}
}
