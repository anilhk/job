package com.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 78. Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 *
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {

    	List<List<Integer>> output = new ArrayList<>();
    	
    	helper(output,new ArrayList<Integer>(), nums, 0);
    	return output;
    	
    }
    
    
    public void helper(List<List<Integer>> output, List<Integer> current, int[] nums, int index) {
    	
    	if (nums.length == index) {
    		
    		output.add(new ArrayList<>(current));
    		return;
    	}
    	
    	current.add(nums[index]);
    	helper(output,current,nums,index+1);
    	current.remove(current.size()-1);
   	 	helper(output,current,nums,index+1);

    	
    }
}
