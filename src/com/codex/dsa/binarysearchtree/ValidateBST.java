package com.codex.dsa.bstree;

import com.codex.dsa.tree.Node;

public class ValidateBST {
	

	public static boolean validateBSTBestApproach(Node root, long  min, long max) {
		if(root == null) {
			return true;
		}
		if(root.data < min || root.data >max) {
			return false;
		}
		return validateBSTBestApproach(root.left, min, root.data-1) && validateBSTBestApproach(root.left, root.data+1, max);
	}
	public static boolean validateBST(Node root) {
		// Valid but not an correct method to validate, As it will failed in some case
		if (root == null) {
			return true;
		}
		
		validateBST(root.left);
		validateBST(root.right);

		if (root.left != null && root.data > root.left.data && root.right != null && root.data < root.right.data) {
			return true;
		}

		return false;
	}
	
	public static boolean validateBST2(Node root) {
		return isBSTUtil(root);
	}
	static Node prev; 
	public static boolean isBSTUtil(Node root) {
		if(root != null) {
			if(!isBSTUtil(root.left)) {
				return false;
			}
			if (prev != null && root.data <= prev.data) 
		        return false; 
		  prev = root;
			
			return isBSTUtil(root.right);
		}
		
		return true;
	}
	public static void main(String[] args) {
		Node root = Node.getRandomBinaryTree();
		System.out.println("isBST :: " + validateBST(root));
		System.out.println("isBST with best approach :: " + validateBSTBestApproach(root, Long.MIN_VALUE, Long.MAX_VALUE));
	}

}
