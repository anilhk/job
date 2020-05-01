package com.problems.leetcode.dp;

/**
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * X X X X X O O X X X O X X O X X After running your function, the board should
 * be:
 * 
 * X X X X X X X X X X X X X O X X
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 *
 */
public class SurroundedRegions_130 {

	public void solve(char[][] board) {
		/*
		 * X X X X 1 1 1 1 X O O X 1 0 0 1 X X O X 1 1 0 1 X O X X 1 2 1 1
		 */

		if (board == null || board.length == 0)
			return;

		int row = board.length;
		int column = board[0].length;
		// convert X and O to 1 and 0 respectively for readability
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == 'X') {
					board[i][j] = '1';
				} else {
					board[i][j] = '0';
				}
			}
		}

		// iterate over outer layers and see if u find 0.
		// these 0 cannot be converted since they are at the edges.
		// so lets update them to random number 2

		// first row
		for (int i = 0; i < column; i++) {
			if (board[0][i] == '0') {

				dfs(0, i, board);

			}
		}

		// first column
		for (int i = 0; i < row; i++) {
			if (board[i][0] == '0') {
				dfs(i, 0, board);
			}
		}

		// last row
		for (int i = 0; i < column; i++) {
			if (board[row - 1][i] == '0') {
				dfs(row - 1, i, board);
			}
		}

		// last column
		for (int i = 0; i < row; i++) {
			if (board[i][column - 1] == '0') {
				dfs(i, column - 1, board);
			}
		}

		// now traverse the full array and convert 1 & 0 to X and 2 to zero.

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == '1' || board[i][j] == '0') {
					board[i][j] = 'X';
				} else {
					board[i][j] = 'O';
				}
			}
		}

	}

	public void dfs(int i, int j, char[][] board) {

		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '2' || board[i][j] == '1') {
			return;
		}

		board[i][j] = '2';
		dfs(i + 1, j, board);
		dfs(i - 1, j, board);
		dfs(i, j + 1, board);
		dfs(i, j - 1, board);

	}
}
