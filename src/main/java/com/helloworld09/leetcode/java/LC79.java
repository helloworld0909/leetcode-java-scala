package com.helloworld09.leetcode.java;

public class LC79 {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * <p>
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * <p>
     * Example:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     */
    public boolean exist(char[][] board, String word) {
        char[] wordCharArray = word.toCharArray();
        for (int i = 0; i< board.length; i++){
            for (int j = 0; j< board[0].length; j++){
                if (exist(board, wordCharArray, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] word, int i, int j, int matches) {
        if (matches >= word.length)
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] != word[matches])
            return false;

        char tmp = board[i][j];
        board[i][j] = '#';
        boolean ret = exist(board, word, i - 1, j, matches + 1) ||
                exist(board, word, i + 1, j, matches + 1) ||
                exist(board, word, i, j - 1, matches + 1) ||
                exist(board, word, i, j + 1, matches + 1);
        board[i][j] = tmp;
        return ret;
    }

    public static void main(String[] args) {

    }
}
