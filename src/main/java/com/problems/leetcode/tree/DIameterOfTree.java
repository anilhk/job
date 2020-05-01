package com.problems.leetcode.tree;

/*
 * 543. Diameter of Binary Tree
  Given a binary tree, you need to compute the length of the diameter of the tree. 
  The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DIameterOfTree {

	public int diameterOfBinaryTree(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int dia = getDiameter(root);
		return dia - 1;
	}

	public int getDiameter(TreeNode root) {

		if (root != null) {
			int lheight = getHeight(root.left);
			int rheight = getHeight(root.right);

			int ldiameter = getDiameter(root.left);
			int rdiameter = getDiameter(root.right);

			int diameter = Math.max(Math.max(ldiameter, rdiameter), lheight + rheight + 1);
			return diameter;
		} else {
			return 0;
		}

	}

	public int getHeight(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

}
