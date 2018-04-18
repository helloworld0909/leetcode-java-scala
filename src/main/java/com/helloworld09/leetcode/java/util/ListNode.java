package com.helloworld09.leetcode.java.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next == null)
            return String.valueOf(val) + " -> null";
        else
            return String.valueOf(val) + " -> " + next.toString();
    }

    public static ListNode getLinkedList(int ... nodeList) {
        if (nodeList.length == 0)
            return null;

        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int nodeVal: nodeList) {
            node.next = new ListNode(nodeVal);
            node = node.next;
        }
        return head.next;
    }
}

