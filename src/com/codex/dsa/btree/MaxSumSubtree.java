package com.codex.dsa.btree;

/**
 *  		  1
            /    \
          -2      3
          / \    /  \
         4   5  -6   2
         o/p = 7 (-2+4+5) = 7
 * @author anutiwar
 *
 */
public class MaxSumSubtree {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(-2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);		
		root.right = new Node(3);
		root.right.left = new Node(-6);
		root.right.right = new Node(2);

		int max_sum = Integer.MIN_VALUE;		
		System.out.println("maxSubTreeSum "+getMaxSum(root, max_sum));
	}

	private static int getMaxSum(Node node, int max_sum) {
		if(node == null) {
			return max_sum;
		}
		int curr_sum = node.data +getMaxSum(node.left, max_sum) + getMaxSum(node.right,max_sum);
		System.out.println("Current Sum "+curr_sum);
		max_sum = Math.max(curr_sum, max_sum);
		return max_sum;
	}
}
