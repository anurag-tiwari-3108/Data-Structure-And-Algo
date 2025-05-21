package com.codex.dsa.trees;

public class DiameterOfTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(12);
		root.left.left = new Node(13);
		root.right.right = new Node(14);
		root.left.left.left = new Node(15);
		root.right.right.right = new Node(16);
		System.out.println("Diameter Of Binary Tree is " + getDiameter(root));
	}

	private static int getDiameter(Node root) {
		if (root == null)
			return 0;
		int leftHieght = HeightOfTree.getHeight(root.left);
		int rightHieght = HeightOfTree.getHeight(root.right);

		int leftDiameter = getDiameter(root.left);
		int rightDiameter = getDiameter(root.right);

		return Math.max(leftHieght + rightHieght + 1, Math.max(leftDiameter, rightDiameter));
	}
}
