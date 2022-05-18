package com.codex.dsa.bstree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.codex.dsa.tree.Node;

/* Construct the following tree
			   8
		     /   \
		    /     \
		  3          5
		 / \       / \
		/   \     /   \
		10  2  4     6
*/
public class ConvertBTtoBST {
	
	private static void extractKeys(Node root, Set<Integer> set) {
		if(root == null) {
			return;
		}
		
		extractKeys(root.left, set);
		set.add(root.data);
		extractKeys(root.right, set);
		
	}
	
	private static void inorder(Node root) {
		if(root == null) {
			return ;
		}
		
		inorder(root.left);
		System.out.print(root.data +" , ");		
		inorder(root.right);
	}
	
	private static void convertToBST(Node root, Iterator<Integer> itr) {
		if(root == null) {
			return ;
		}
		convertToBST(root.left, itr);
		root.data = itr.next();
		convertToBST(root.right, itr);
		
	}
	public static void main(String[] args) {
		Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        
        Set<Integer> set = new TreeSet<>();
        extractKeys(root, set);
        inorder(root);
        System.out.println();
        // put back keys present in the set to their correct order in the BST
        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);
 
        // print the BST
        inorder(root);
	}
}
