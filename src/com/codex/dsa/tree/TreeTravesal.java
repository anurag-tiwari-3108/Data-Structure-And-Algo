package com.codex.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTravesal {
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new BinarayTreeNode(10);
		tree.root.left = new BinarayTreeNode(11);
		tree.root.right = new BinarayTreeNode(12);
		tree.root.left.left = new BinarayTreeNode(13);
		tree.root.right.right = new BinarayTreeNode(14);
		tree.root.left.left.left = new BinarayTreeNode(15);
		tree.root.right.right.right = new BinarayTreeNode(16);

		
		System.out.println("Pre Order Travesal In Recursive Way");
		printPreOrderRecursive(tree.root);
		
		System.out.println();
		System.out.println("Post Order Travesal In Recursive Way");	
		printPostOrderRecursive(tree.root);

		System.out.println();
		System.out.println("In Order Travesal In Recursive Way");
		printInOrderRecursive(tree.root);
		
		System.out.println("Pre Order Travesal In Iterative Way");
		printPreOrderIteratively(tree.root);

		System.out.println();
		System.out.println("Post Order Travesal In Iterative Way");
		printPostOrderIteratively(tree.root);

		System.out.println();
		System.out.println("In Order Travesal In Iterative Way");
		printInOrderIteratively(tree.root);
	}
	
	public static void printPreOrderIteratively(BinarayTreeNode root) {
		Queue<BinarayTreeNode> q = new LinkedList<BinarayTreeNode>();
		
	}
	
	public static void printPostOrderIteratively(BinarayTreeNode root) {
		
	}
	
	public static void printInOrderIteratively(BinarayTreeNode root) {
		
	}

	public static void printPreOrderRecursive(BinarayTreeNode root) {
		// Root ->Left -> Right
		if (root == null) {
			return;
		}
		System.out.print(root.key+" ");
		printPreOrderRecursive(root.left);
		printPreOrderRecursive(root.right);
	}

	public static void printPostOrderRecursive(BinarayTreeNode root) {
		// Left -> Right -> Root
		if (root == null) {
			return;
		}
		printPostOrderRecursive(root.left);
		printPostOrderRecursive(root.right);
		System.out.print(root.key+" ");
	}

	public static void printInOrderRecursive(BinarayTreeNode root) {
		if (root == null) {
			return;
		}
		printInOrderRecursive(root.left);
		System.out.print(root.key+" ");
		printInOrderRecursive(root.right);
	}
}
