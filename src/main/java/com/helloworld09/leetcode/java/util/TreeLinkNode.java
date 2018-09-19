package com.helloworld09.leetcode.java.util;

public class TreeLinkNode extends TreeNode {
    public TreeLinkNode next;
    public TreeLinkNode left;
    public TreeLinkNode right;

    @Override
    public int getVal() {
        return val;
    }

    @Override
    public TreeLinkNode getLeft() {
        return left;
    }

    @Override
    public TreeLinkNode getRight() {
        return right;
    }

    public TreeLinkNode getNext() {
        return next;
    }

    public TreeLinkNode(int x) {
        val = x;
    }

    public static TreeLinkNode getTestTree() {
        TreeLinkNode input = new TreeLinkNode(0);
        input.left = new TreeLinkNode(1);
        input.right = new TreeLinkNode(2);
        input.left.next = input.right;
        input.left.left = new TreeLinkNode(3);
        return input;
    }

    public static void main(String[] args) {
        TreeVisualize.draw(getTestTree());
    }
}
