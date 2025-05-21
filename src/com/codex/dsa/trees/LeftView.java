package com.codex.dsa.trees;

class LeftTreeNode {
	int data;
	Node left, right;

	public LeftTreeNode(int item) {
		data = item;
		left = right = null;
	}
}

public class LeftView {
	Node root;
	static int max_level = 0;

	public void getLeftView() {
		printLeftView(root, 1);
	}

	public void printLeftView(Node node, int level) {
		if (node == null) {
			return;
		}
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}
		// if call node.left is called first then left view 
		// if called node.right then right view
		printLeftView(node.left, level + 1);
		printLeftView(node.right, level + 1);
	}

	public static void main(String[] args) {
		LeftView tree = new LeftView();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(8);
		tree.root.right.right = new Node(15);
		tree.root.right.left = new Node(12);
		tree.root.right.right.left = new Node(14);
        
		tree.getLeftView();
	}
}
