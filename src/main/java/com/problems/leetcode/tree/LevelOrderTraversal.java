package com.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	
	public List<List<Integer>> levelOrderTraversal(TreeNode root) {
		
		List<List<Integer>> output = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			List<Integer> list = new ArrayList<>();
			
			for(int i=0;i<size;i++) {
				
				TreeNode current = queue.poll();
				list.add(current.val);
				
				if (current.left != null) {
					queue.add(current.left);
				}
				
				if (current.right != null) {
					queue.add(current.right);
				}
				
			}
			output.add(list);
		}
		
		return output;
	}
}
