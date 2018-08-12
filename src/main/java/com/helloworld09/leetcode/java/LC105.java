package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC105 {
    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecursion(preorder, inorder, 0, 0, inorder.length);
    }

    private TreeNode buildTreeRecursion(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart >= inEnd || preStart >= preorder.length) {
            return null;
        }

        int rootVal = preorder[preStart];
        int idx = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeRecursion(preorder, inorder, preStart + 1, inStart, idx);
        root.right = buildTreeRecursion(preorder, inorder, preStart + 1 + idx - inStart, idx + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        LC105 solution = new LC105();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode tree = solution.buildTree(preorder, inorder);

        System.out.println(new LC102().levelOrder(tree));
    }
}
