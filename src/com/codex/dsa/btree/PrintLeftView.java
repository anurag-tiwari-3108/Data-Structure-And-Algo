package com.codex.dsa.btree;

public class PrintLeftView {
	Node root;
	static int max_level = 0;

	public void getLeftView() {
		printLeftViewRecursive(root, 1);
	}

	public void printLeftViewIteratively(Node node, int level) {
		
	} 
	public void printLeftViewRecursive(Node node, int level) {
		if (node == null) {
			return;
		}
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}
		// if call node.left is called first then left view if called node.right then
		// right view
		printLeftViewRecursive(node.left, level + 1);
		printLeftViewRecursive(node.right, level + 1);
	}

	public static void main(String[] args) {
		PrintLeftView tree = new PrintLeftView();
		tree.root = Node.getRandomBinaryTree();
		tree.getLeftView();
	}
}
