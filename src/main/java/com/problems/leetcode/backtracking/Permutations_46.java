package com.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 46. Permutations
 * 
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
 * ]
 *
 */
public class Permutations_46 {

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return output;
		}

		helper(output, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return output;
	}

	public void helper(List<List<Integer>> output, List<Integer> current, int[] nums, boolean[] visited) {

		if (current.size() == nums.length) {
			output.add(new ArrayList<Integer>(current));
			return;

		}

		for (int i = 0; i < nums.length; i++) {

			if (visited[i]) {
				continue;
			}

			current.add(nums[i]);
			visited[i] = true;
			helper(output, current, nums, visited);
			current.remove(current.size() - 1);
			visited[i] = false;
		}

	}
}
