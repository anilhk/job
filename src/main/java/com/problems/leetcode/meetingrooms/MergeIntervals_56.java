package com.problems.leetcode.meetingrooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 */
public class MergeIntervals_56 {

	 public int[][] merge(int[][] intervals) {
		 List<int[]> list = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int []>() {
		
			@Override
			public int compare(int[] a, int[] b) {
				return a[0]-b[0];
			}
			
		});
	  //[1,3],[2,6],[8,10],[15,18]
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		for(int i=1;i<intervals.length;i++) {
			
			if (intervals[i][1]<start) {
				//merge
				end = Math.max(end, intervals[i][1]);
			}else {
				list.add(new int[] {start,end});
				start = intervals[i][0];
				end = intervals[i][1];
			}
			
		}
		list.add(new int[] {start,end});
		return list.toArray(new int[0][]);
	 }
}
