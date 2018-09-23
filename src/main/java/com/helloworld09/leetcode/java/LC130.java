package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.Grid;

import java.util.*;

public class LC130 {
    /**
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     * <p>
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * <p>
     * Example:
     * <p>
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     * <p>
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * Explanation:
     * <p>
     * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
     */
    public void solve(char[][] board) {
        int m = board.length;
        int n = m == 0 ? 0 : board[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    board[i][j] = '*';
                    Queue<Point2D> queue = new LinkedList<>();
                    queue.add(new Point2D(i, j));

                    while (!queue.isEmpty()) {
                        Point2D p = queue.poll();
                        for (int[] d : directions) {
                            int x = d[0] + p.x;
                            int y = d[1] + p.y;
                            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                                board[x][y] = '*';
                                queue.add(new Point2D(x, y));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    class Point2D {
        int x;
        int y;

        Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        LC130 solution = new LC130();
        char[][] input = Grid.getUniformGrid(4, 4, 'X');
        input[1][1] = input[1][2] = input[2][2] = input[3][1] = 'O';
        solution.solve(input);
        Grid.printGrid(input);
    }
}
