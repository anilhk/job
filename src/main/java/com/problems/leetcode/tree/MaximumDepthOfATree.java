package com.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
public class MaximumDepthOfATree {

	public int maxDepth(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		List<List<Integer>> output = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			
			List<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				
			 TreeNode node = queue.poll();
			 list.add(node.val);
			 
			 if (node.left != null) {
				 queue.add(node.left);
			 }
			 
			 if (node.right != null) {
				 queue.add(node.right);	 
			 }
			 
			}
			
			output.add(list);
		
		}
		
		return output.size();
	}
}
