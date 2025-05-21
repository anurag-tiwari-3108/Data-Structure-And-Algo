package com.codex.dsa.trees;

public class BoundaryOfBinaryTree {

	public static void performBoundaryTraversal(Node root) {

		if (root == null) {
			return;
		}

		printLeftBoundary(root.left);

		if (!root.isLeaf()) {
			printLeafNodes(root);
		}

		printRightBoundary(root.right);

	}

	private static void printRightBoundary(Node root) {
		if (root == null || root.isLeaf()) {
            return;
        }
 
        // recur for the right child of `root` if it exists;
        // otherwise, recur for the left child
        printRightBoundary(root.right != null ? root.right: root.left);
 
        // To ensure bottom-up order, print the value of the nodes
        // after recursion unfolds
        System.out.print(root.data + " ");

	}

	private static void printLeftBoundary(Node root) {
		 // base case: root is empty
        if (root == null) {
            return;
        }
 
        Node node = root;
 
        // do for all non-leaf nodes
        while (!node.isLeaf())
        {
            // print the current node
            System.out.print(node.data + " ");
 
            // next process, the left child of `root` if it exists;
            // otherwise, move to the right child
            node = (node.left != null) ? node.left: node.right;
        }
	}

	private static void printLeafNodes(Node root) {
		
		if(root == null) {
			return;
		}
        printLeafNodes(root.left);
		if(root.isLeaf()) {
			System.out.println(root.data);
		}
        printLeafNodes(root.right);
		
	}

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}

		// Utility function to check if a given node is a leaf node
		boolean isLeaf() {
			return this.left == null && this.right == null;
		}
	}
}
