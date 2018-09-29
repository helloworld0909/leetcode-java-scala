package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.RandomListNode;

public class LC138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode headCopy = new RandomListNode(head.label);
        map.put(head, headCopy);

        RandomListNode cur = head.next;
        RandomListNode curCopy = headCopy;
        while (cur != null) {
            curCopy.next = new RandomListNode(cur.label);
            map.put(cur, curCopy.next);
            cur = cur.next;
            curCopy = curCopy.next;
        }

        cur = head;
        curCopy = headCopy;
        while (cur != null) {
            if (cur.random != null) {
                curCopy.random = map.get(cur.random);
            }
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return headCopy;
    }

    public static void main(String[] args) {

    }
}
