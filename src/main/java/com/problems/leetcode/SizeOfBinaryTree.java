package com.problems.leetcode;

public class SizeOfBinaryTree {

	public int size(TreeNode root) {
	
		return getSize(root);
	}
	
	public int getSize(TreeNode root) {
		
		if (root == null) {
			return 0;
		}else {
			return 1 + getSize(root.left) + getSize(root.right);
		}
	}
}
