package com.helloworld09.leetcode.java.util;

public class TreeLinkNode extends TreeNode {
    public TreeLinkNode next;
    public TreeLinkNode left;
    public TreeLinkNode right;

    public TreeLinkNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        TreeVisualize.draw(getTestTree());
    }
}
