package com.codex.dsa.trees;

public class LowestCommonAncestor {

	public Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (root == null || root == p || root == q)
			return root;
		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;

	}

}
