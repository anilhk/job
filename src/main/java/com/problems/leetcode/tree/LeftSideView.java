package com.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 2, 5]
Explanation:

 --->	  1            
 --->	/   \
--->	2     3         
---> 	\     \
--->  	 5     4       
---> */
public class LeftSideView {

	public List<Integer> leftSideView(TreeNode root) {
		
		List<Integer> output = new ArrayList<>();
		
		 if (root == null)
			 return output;
		 
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(root);
		
			while(!queue.isEmpty()) {
				
				int size = queue.size();
				for(int i=0;i<size;i++) {
					
				
					TreeNode current = queue.poll();
					 if (i==0) {
						 output.add(current.val);
					 }
					 
					 if (current.left != null) {
						 queue.add(current.left);
					 }
					 
					 if (current.right != null) {
						 queue.add(current.right);
					 }
					
				}
				
			}
		
		 return output;		 
	}
}
