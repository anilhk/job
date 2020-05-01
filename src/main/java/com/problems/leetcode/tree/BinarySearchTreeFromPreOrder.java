package com.problems.leetcode.tree;
/*
 * 1008. Construct Binary Search Tree from Preorder Traversal

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, 
any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val. 

 Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 https://assets.leetcode.com/uploads/2019/03/06/1266.png

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.
 */
public class BinarySearchTreeFromPreOrder {

	int[] preorder;
	int index=0;
	
	 public TreeNode bstFromPreorder(int[] preorder) {
         
		 this.preorder = preorder;
		 return makeBST(Integer.MIN_VALUE,Integer.MAX_VALUE);
		 
		 
	 }	 
	 
	 public TreeNode makeBST(Integer lower,Integer higher) {
		 
		 // breaking condition
		 if (index==preorder.length) {
			 return null;
		 }
		 
		 int value = preorder[index];
		 
		 if (value<lower || value>higher) {
			   return null;
		 }
		 
		 index++;
		 TreeNode node = new TreeNode(value);
		 node.left = makeBST(lower,value);
		 node.right  = makeBST(value,higher);
		 
		 return node;
	 }
}
