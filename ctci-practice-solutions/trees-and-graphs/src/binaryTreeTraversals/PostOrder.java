package binaryTreeTraversals;

import node.BinaryTreeNode;

public class PostOrder {

    public static void printNodes(BinaryTreeNode node) {
        if (node != null) {
            printNodes(node.left);
            printNodes(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(8);
        root.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(10);
        printNodes(root);
    }
}
