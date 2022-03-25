package com.codex.dsa.btree;

public class BinarayTreeNode {
	int key;
	BinarayTreeNode left, right;
	public BinarayTreeNode(int item) {
		this.key = item;
		left = right = null;
	}
}
