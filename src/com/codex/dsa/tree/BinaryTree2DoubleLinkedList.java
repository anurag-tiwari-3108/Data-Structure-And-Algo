package com.codex.dsa.tree;

public class BinaryTree2DoubleLinkedList {
	static Node prev = null;
	Node head;
	void convertToDoubllyLinkedList(Node root) {
		 // Base case
        if (root == null)
            return;
  
        // Recursively convert left subtree
        convertToDoubllyLinkedList(root.left);
  
        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
  
        // Finally convert right subtree
        convertToDoubllyLinkedList(root.right);
	}

}
