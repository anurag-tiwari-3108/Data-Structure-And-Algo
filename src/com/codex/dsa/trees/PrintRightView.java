package com.codex.dsa.trees;

public class PrintRightView {
	static int max_level = 0;
	public static void main(String[] args) {
		Node tree = Node.getRandomBinaryTree();
		printRightView(tree, 0);
	}

	private static void printRightView(Node node, int level) {

		if (node == null) {
			return;
		}
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}
		// if call node.left is called first then left view if called node.right then right view
		printRightView(node.right, level + 1);
		printRightView(node.left, level + 1);
	}
}
