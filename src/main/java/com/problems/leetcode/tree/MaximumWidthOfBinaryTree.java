package com.problems.leetcode.tree;
/*
 * 662. Maximum Width of Binary Tree
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.

/**
https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/106653/Java-One-Queue-Solution-with-HashMap

inspired by dicco in the cooments 
*/

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Queue<Integer> indicesQueue = new LinkedList<Integer>();

		nodeQueue.add(root);
		indicesQueue.add(1);

		int start = 0;
		int end = 0;
		int max = 0;
		while (!nodeQueue.isEmpty()) {

			int size = nodeQueue.size();

			for (int i = 0; i < size; i++) {

				TreeNode node = nodeQueue.poll();
				int index = indicesQueue.poll();
				if (i == 0) {
					start = index;
				}
				if (i == size - 1) {
					end = index;
				}

				if (node.left != null) {
					nodeQueue.offer(node.left);
					indicesQueue.offer(2 * index);
				}

				if (node.right != null) {

					nodeQueue.offer(node.right);
					indicesQueue.offer(2 * index + 1);
				}

			}

			max = Math.max(max, end - start + 1);

		}

		return max;
	}
}
