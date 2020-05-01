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
public class Permutations_46_String {

	public static void main(String args[]) {
		
		Permutations_46_String a = new  Permutations_46_String();
		List<List<String>> result =  a.permute("abc");
		for(List<String> slist : result) {
			
			for(String  str : slist) {
				System.out.println(str);
			}
		}
		
	}
	public List<List<String>> permute(String str) {

		List<List<String>> output = new ArrayList<>();

		if (str == null || str.length() == 0) {
			return output;
		}

		helper(output, new ArrayList<Character>(), str.toCharArray(), new boolean[str.length()]);
		return output;
	}

	public void helper(List<List<String>> output, List<Character> current, char[] nums, boolean[] visited) {

		if (current.size() == nums.length) {
			
			StringBuilder builder = new StringBuilder();
			for(char c : current) {
				builder.append(c);
			}
			
			List<String> a = new ArrayList<String>();
			a.add(builder.toString());
			output.add(a);
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
