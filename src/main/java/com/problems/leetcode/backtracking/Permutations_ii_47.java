package com.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 *
 */
public class Permutations_ii_47 {

	 public List<List<Integer>> permuteUnique(int[] nums) {
		 
		 List<List<Integer>> output = new ArrayList<>();
		 
		 if (nums == null || nums.length == 0) {
			 return output;
		 }
		 Arrays.sort(nums);
		 
		 helper(output,new ArrayList<Integer>(), nums, new boolean[nums.length]);
		 return output;
	 }
	 
	 public void helper(List<List<Integer>> output, List<Integer> current, int[] nums, boolean[] visited) {
		 
		 
		 if (current.size()==nums.length) {
			 
			 output.add(new ArrayList<>(current));
			 return;
		 }
		 
		 for(int i=0;i<nums.length;i++) {
			 
			 if (visited[i]) {
				 continue;
			 }
			 
			
			 current.add(nums[i]);
			 visited[i]=true;
			 helper(output,current,nums,visited);
			 current.remove(current.size()-1);
			 visited[i]=false;
		 
		 }
	 }
}
