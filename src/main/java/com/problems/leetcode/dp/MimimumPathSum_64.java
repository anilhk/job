package com.problems.leetcode.dp;

/**
 * 
 * 64. Minimum Path Sum Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all
 * numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7
 * 
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * 
 */
public class MimimumPathSum_64 {

	public int minPathSum(int[][] grid) {

		if (grid == null) {
			return 0;
		}

		int row = grid.length;
		int column = grid[0].length;

		int[][] dp = new int[row][column];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				dp[i][j] = dp[i][j] + grid[i][j];

				if (i > 0 && j > 0) {

					dp[i][j] = dp[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				} else if (i > 0) {

					dp[i][j] = dp[i][j] + dp[i - 1][j];
				} else if (j > 0) {
					dp[i][j] = dp[i][j] + dp[i][j - 1];
				}
			}
		}

		return dp[row - 1][column - 1];
	}
}
