package com.problems.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

	
	// Left -- Root -- Right -- this traversal will print in the sorted order. Always. 
	
	public List<Integer> inOrderTraversal(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> output = new ArrayList<Integer>();
		
		 TreeNode current = root;
		 while(current != null || !stack.isEmpty()) {
			 
			 	while(current != null) {
			 		
			 		stack.push(current);
			 		current = current.left;
			 		
			 	}
			 	
			 	current = stack.pop();
			 	output.add(current.val);
			 	current = current.right;
			 	
		 }
		return output;
		
	}
}
