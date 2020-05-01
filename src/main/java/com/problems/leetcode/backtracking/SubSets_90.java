package com.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * 90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 *
 */
public class SubSets_90 {

	public List<List<Integer>> subsets(int[] nums) {

    	List<List<Integer>> output = new ArrayList<>();
    	Arrays.sort(nums);
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
    	
    	while(index+1<nums.length && nums[index]==nums[index+1]) {
    	
    		index++;
    	}
    	
   	 	helper(output,current,nums,index+1);

    	
    }
}
