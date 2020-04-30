package com.problems.leetcode;

import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

	public List<Integer> preOrder(TreeNode root, List<Integer> output) {

		if (root == null) {
			return output;
		}

		// Root L R
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();
			// push the root to output
			output.add(node.val);

			// first add right then left, sinc stack is LIFO so add right first so that left
			// comes of first
			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}

		}

		return output;
	}
	
	public List<Integer> preOrderRecursion(TreeNode root,List<Integer> output) {
		
					if (root != null) {
						
						output.add(root.val);
						
						if (root.left != null) {
							preOrderRecursion(root.left,output);
						}
						
						if (root.right != null) {
							preOrderRecursion(root.right,output);
						}
					}
					return output;
	}

}
