package com.problems.leetcode.tree;
/*
 * 124. Binary Tree Maximum Path Sum
	Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
public class BinaryTreeMaximumPathSum {

	public Integer result = Integer.MIN_VALUE;
	
	 public int maxPathSum(TreeNode root) {
		 
		 maxPathUtil(root);
		 return result;
	 }
	 
	 public int maxPathUtil(TreeNode root) {
		 
		 if (root == null) {
			 return 0;
		 }
		 
		 int left = maxPathUtil(root.left);
		 int right = maxPathUtil(root.right);
		 int maxPath = Math.max(Math.max(left,right)+root.val, root.val);
		 int maxValue = Math.max(maxPath, root.val + left + right);
		 result = Math.max(result, maxValue);
		 return maxPath;
		 
	 }
}
