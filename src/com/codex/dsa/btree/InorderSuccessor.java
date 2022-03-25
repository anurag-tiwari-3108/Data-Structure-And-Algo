package com.codex.dsa.btree;

// Inorder successor would be the next big number in in order travesal 
public class InorderSuccessor {

	public static Node getSuccessor(Node root, Node successorNode, int key) {
		if (root == null) {
			return new Node(key);
		}

		if (root.data == key) {
			if(root.right != null) {
				return getMinimumFromTree(successorNode);
			}
		} else if (key < root.data) {
			successorNode = root;
			return getSuccessor(root.left, successorNode, key);
		}
		else {
			return getSuccessor(root.right, successorNode, key);
		}
		return successorNode;

	}

	private static Node getMinimumFromTree(Node node) {
		if (node == null) {
			return null;
		}
		while (node != null) {
			node = node.left;
		}
		return node;
	}

}
