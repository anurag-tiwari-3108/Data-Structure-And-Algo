package com.codex.dsa.trees;

public class BinaryTree {
    BinarayTreeNode root;

    public BinaryTree() {
        root = null;
    }

    // Insert a node in the binary tree (level order)
    public void insert(int data) {
        BinarayTreeNode newNode = new BinarayTreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        java.util.Queue<BinarayTreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinarayTreeNode temp = queue.poll();
            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    // Inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }
    private void inorder(BinarayTreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    // Main method for demonstration
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}
