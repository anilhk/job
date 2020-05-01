package com.problems.leetcode.dp;

/**
 * 
 * 79. Word Search Given a 2D board and a word, find if the word exists in the
 * grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * 
 * Given word = "ABCCED", return true. 
 * Given word = "SEE", return true. 
 * Given word = "ABCB", return false.
 * 
 * 
 * Constraints:
 * 
 * board and word consists only of lowercase and uppercase English letters. 
 * 1 <= board.length <= 200 
 * 1 <= board[i].length <= 200 
 * 1 <= word.length <= 10^3
 *
 */
public class wordSearch_79 {

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == word.charAt(0) && doesWordExists(board, i, j, 0, word)) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean doesWordExists(char[][] board, int i, int j, int index, String word) {

		if (index == word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
			return false;
		}

		char temp = board[i][j];
		board[i][j] = ' ';
		boolean doesWordExists =

				doesWordExists(board, i + 1, j, index + 1, word) || doesWordExists(board, i - 1, j, index + 1, word)
						|| doesWordExists(board, i, j + 1, index + 1, word)
						|| doesWordExists(board, i, j - 1, index + 1, word);

		board[i][j] = temp;
		return doesWordExists;

	}
}
