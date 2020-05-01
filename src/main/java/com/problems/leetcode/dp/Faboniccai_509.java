package com.problems.leetcode.dp;

/*
 * 
 * 509. Fibonacci Number

 * The Fibonacci numbers, commonly denoted F(n) form a sequence, 
 * called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
 *  starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

 

Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Note:

0 ≤ N ≤ 30.

Time complexity - O(N)
Space Complexity O(1) 
 */
public class Faboniccai_509 {

	public int fib(int N) {

		// 0! = 0
		if (N == 0) {
			return 0;
		}

		// 1! = 1,
		// 2! = 1
		if (N <= 2) {
			return 1;
		}

		// 0! = 0
		int first = 0;

		// 1! = 1
		int second = 1;
		for (int i = 2; i <= N; i++) {

			int third = first + second;
			first = second;
			second = third;

		}
		return second;

	}
}
