package com.codex.dsa.btree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Objective: Given a Binary tree create Linked Lists of all the nodes at each
 * depth , say if the tree has height k then create k linked lists. Approches :
 * 1) BFS or Level Order Travesal 2) Modify the PreOrderTraversal and store the
 * level along with data for each level Will Use Approch 1
 */
public class ListOfDepth {

	public static ArrayList<LinkedList<Node>> getListOfDepth(Node root) {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

		LinkedList<Node> current = new LinkedList<Node>();
		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();

			for (Node parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
	}

}
