package com.codex.dsa.btree;

public class HieghtBalanceBT {
	
	public static void main(String [] args) {
//		Node node = Node.getRandomBinaryTree();
//		Node.printPreOrderRecursive(node);
//		System.out.println("Is Height Balanced tree ? "+isHieghtBalancedTree(node));
	}

	private static boolean isHieghtBalancedTree(Node node) {
		if(node == null) {
			return Boolean.TRUE;
		}
		
		int lhieght = HeightOfTree.getHeight(node.left);
		int rhieght = HeightOfTree.getHeight(node.right);
		
		if (Math.abs(lhieght - rhieght) <=1) {
			return true;
		}
			
		return false;
	}

}
