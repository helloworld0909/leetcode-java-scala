package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC106 {
    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRecursion(inorder, postorder, postorder.length - 1, 0, inorder.length);
    }

    private TreeNode buildTreeRecursion(int[] inorder, int[] postorder, int postRoot, int inStart, int inEnd) {
        if (inStart >= inEnd || postRoot < 0) {
            return null;
        }

        int rootVal = postorder[postRoot];
        int idx = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeRecursion(inorder, postorder, postRoot - inEnd + idx, inStart, idx);
        root.right = buildTreeRecursion(inorder, postorder, postRoot - 1, idx + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        LC106 solution = new LC106();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        System.out.println(new LC102().levelOrder(solution.buildTree(inorder, postorder)));
    }
}
