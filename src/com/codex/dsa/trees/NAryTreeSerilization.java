package com.codex.dsa.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Serialisation  is the process of converting a data structure or object into a sequence of bits so that 
//it can be stored in a file or memory buffer, or transmitted across a network connection link to be 
//reconstructed later in the same or another computer environment.
//Design an algorithm to serialise and deserialised an N-ary tree. An N-ary tree is a rooted tree in which each NAryTree 
//has no more than N children. There is no restriction on how your serialisation/deserialisation algorithm should work. 
//You just need to ensure that an N-ary tree can be serialised to a string and this string can be deserialised to the original tree structure.


public class NAryTreeSerilization {
	// Encodes a tree to a single string.

	public String serialize(NAryTree root) {
		StringBuilder sb = new StringBuilder();

		serial(sb, root);

		// System.out.println(sb.toString());
		return sb.toString();
	}

	private void serial(StringBuilder sb, NAryTree root) {
		if (root == null) {
			sb.append("#");
			sb.append(",");
		} else {
			sb.append(root.val);
			sb.append(",");
			if (root.children != null) {
				sb.append(root.children.size());
				sb.append(",");
				for (NAryTree child : root.children) {
					serial(sb, child);
				}
			}
		}
	}

	// Decodes your encoded data to tree.
	public NAryTree deserialize(String data) {
		Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(",")));

		return buildTree(queue);
	}

	private NAryTree buildTree(Queue<String> queue) {
		String val = queue.poll();
		if (val.equals("#")) {
			return null;
		}

		NAryTree root = new NAryTree(Integer.parseInt(val), null);
		int childrenCount = Integer.parseInt(queue.poll());

		root.children = new ArrayList<NAryTree>();
		for (int i = 0; i < childrenCount; i++) {
			root.children.add(buildTree(queue));
		}
		return root;
	}
}