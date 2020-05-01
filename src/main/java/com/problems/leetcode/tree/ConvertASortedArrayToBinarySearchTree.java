package com.problems.leetcode.tree;

/*
 * 	108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order,
 convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which 
the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

public class ConvertASortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		
		 	return makeBST(nums,0,nums.length-1);
	}
	
	public TreeNode makeBST(int[] nums,int start, int end) {
		
		if (start>end) {
			return null;
		}
		
		int middle = (start + (end-start))/2;
		int value = nums[middle];
		TreeNode node = new TreeNode(value);
		node.left = makeBST(nums,start,middle-1);
		node.right = makeBST(nums,middle+1,end);
		return node;
			
		
	}
}
