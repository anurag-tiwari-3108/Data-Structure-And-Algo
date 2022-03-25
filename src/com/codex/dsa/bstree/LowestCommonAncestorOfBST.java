package com.codex.dsa.bstree;

import com.codex.dsa.btree.Node;

/**
 * First Common Ancestor and Least/Lowest Common Ancestor is same for Binary
 * (Search)Tree
 * 
 * @author anutiwar
 *
 */

public class LowestCommonAncestorOfBST {

	public static Node getLowestCommonAncestor(Node root, Node node1, Node node2) {
		if (root.data > Math.max(node1.data, node2.data)) {
			return getLowestCommonAncestor(root.left, node1, node2);
		} else if (root.data < Math.max(node1.data, node2.data)) {
			return getLowestCommonAncestor(root.right, node1, node2);
		}
		return root;
	}

}
