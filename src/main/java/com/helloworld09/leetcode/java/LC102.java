package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC102 {
    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its level order traversal as:
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> traversal = new HashMap<>();
        TreeNode cur = root;
        Integer curDepth = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                traversal.putIfAbsent(curDepth, new ArrayList<>());
                traversal.get(curDepth).add(cur.val);

                stack.push(cur);
                depthStack.push(curDepth);
                cur = cur.left;
                curDepth += 1;
            }

            cur = stack.pop();
            curDepth = depthStack.pop();
            cur = cur.right;
            curDepth += 1;
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < traversal.size(); i++) {
            ret.add(traversal.get(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        LC102 solution = new LC102();
        System.out.println(solution.levelOrder(TreeNode.getTestTree()));
    }
}
