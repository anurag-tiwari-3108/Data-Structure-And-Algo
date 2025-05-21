package com.codex.dsa.trees;

/**
 * https://www.techiedelight.com/construct-full-binary-tree-from-preorder-sequence-with-leaf-information/
 * Question asked in vmware interview
 * @author anutiwar
 */
public class BuildSpecialTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // Helper index class to keep track of current index in preorder
    static class Index {
        int idx = 0;
    }

    // Function to construct full binary tree from preorder and leaf info
    public static Node buildTree(int[] preorder, char[] isLeaf) {
        Index index = new Index();
        return buildTreeUtil(preorder, isLeaf, index);
    }

    private static Node buildTreeUtil(int[] preorder, char[] isLeaf, Index index) {
        if (index.idx >= preorder.length) return null;
        Node node = new Node(preorder[index.idx]);
        if (isLeaf[index.idx] == 'L') {
            index.idx++;
            return node;
        }
        index.idx++;
        node.left = buildTreeUtil(preorder, isLeaf, index);
        node.right = buildTreeUtil(preorder, isLeaf, index);
        return node;
    }

    // Inorder traversal for testing
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {10, 30, 20, 5, 15};
        char[] isLeaf = {'N', 'N', 'L', 'L', 'L'};
        Node root = buildTree(preorder, isLeaf);
        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();
    }
}
