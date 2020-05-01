package com.problems.leetcode.dp;

/*
 * 
 *  63. Unique Paths II

	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	The robot can only move either down or right at any point in time. 
	The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).


Now consider if some obstacles are added to the grids. How many unique paths would there be?

https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.

There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

 */
public class UniquePaths2_63 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null) {
			return 0;
		}

		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;

		// result
		int[][] dp = new int[row][column];

		// first entry point is 1 then we cannot go further.
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		// first row there is just one path if its 0. if we encounter 1 that means its a
		// dead end.
		for (int i = 0; i < column; i++) {

			if (obstacleGrid[0][i] == 1) {
				break;
			} else {
				dp[0][i] = 1;
			}
		}

		// first column there is just one path if its 0. if we encounter 1 that means
		// its a dead end.
		for (int i = 0; i < row; i++) {

			if (obstacleGrid[i][0] == 1) {
				break;
			} else {
				dp[i][0] = 1;
			}
		}

		// meat of the problem is here if obstacles[i][j] = 0 only then calculate number
		// of ways
		// for that cell else if we have an obstacle we cannot go ahead from that cell
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {

				if (obstacleGrid[i][j] != 1) {

					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}

			}
		}

		return dp[row - 1][column - 1];
	}
}
