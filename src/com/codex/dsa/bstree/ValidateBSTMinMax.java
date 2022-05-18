package com.codex.dsa.bstree;

import com.codex.dsa.tree.Node;

public class ValidateBSTMinMax {

	public static boolean validateBST(Node root) {
		return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean validateBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.data < min || root.data > max) {
			return false;
		}

		return (validateBST(root.left, min, root.data-1) && validateBST(root.right, root.data, max+1));
	}
}
