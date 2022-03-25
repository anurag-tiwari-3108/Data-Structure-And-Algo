package com.codex.dsa.btree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class BottomViewNode {
	int data; 
	int hd; 
	BottomViewNode left, right; 
	public BottomViewNode(int key) {
		data = key;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}
}

public class BottomView {
	
	BottomViewNode root;
	
	public void printBottonView(BottomViewNode root,int level) {
		if(root == null) {
			return;
		}
		 // TreeMap which stores key value pair sorted on key value 
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue to store tree nodes in level order traversal 
        Queue<BottomViewNode> queue = new LinkedList<BottomViewNode>(); 		
        root.hd = level;
        queue.add(root);
        while(!queue.isEmpty()) {
        	BottomViewNode temp= queue.remove();
        	level = temp.hd;
        	
            map.put(level, temp.data); 

        	if(root.left != null) {
        		root.left.hd = level-1;
        		queue.add(root.left);
        	}
        	if(root.right != null) {
        		root.right.hd = level+1;
        		queue.add(root.right);
        	}
        
        	Set<Entry<Integer, Integer>> set = map.entrySet(); 
        	  
            // Make an iterator 
            Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
      
            // Traverse the map elements using the iterator. 
            while (iterator.hasNext()) 
            { 
                Map.Entry<Integer, Integer> me = iterator.next(); 
                System.out.print(me.getValue()+" "); 
            } 
        }
		
        
		
		
	}
	
	
	public static void main(String[] args) {
		BottomView tree = new BottomView();
		tree.root = new BottomViewNode(10);
		tree.root.left = new BottomViewNode(2);
		tree.root.right = new BottomViewNode(3);
		tree.root.left.left = new BottomViewNode(7);
		tree.root.left.right = new BottomViewNode(8);
		tree.root.right.right = new BottomViewNode(15);
		tree.root.right.left = new BottomViewNode(12);
		tree.root.right.right.left = new BottomViewNode(14);
		tree.printBottonView(tree.root, 0);

	}
}
