package com.problems.leetcode.meetingrooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 *  find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

NOTE: input types have been changed on April 15, 2019.

 
 Please reset to default code definition to get new method signature.

 *
 */
public class MeetingRooms_253 {

    public int minMeetingRooms(int[][] intervals) {

	  if (intervals == null || intervals.length==0) {
          return 0;
      }
       
       Arrays.sort(intervals, new Comparator<int[]>() {
          
           public int compare(int[] a, int[] b) {
                return a[0]-b[0];
           }
       });
       
       PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(intervals[0][1]);
       
        // [2,4],[7,10]
        for(int i=1;i<intervals.length;i++) {
        	if (intervals[i][0]>=queue.peek()) {
        		 queue.poll();
        	}
        	queue.add(intervals[i][1]);
        }
    
    return queue.size();
    }
            
}
