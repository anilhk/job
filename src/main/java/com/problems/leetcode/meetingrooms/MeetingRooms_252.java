package com.problems.leetcode.meetingrooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * Example 1:
 * 
 * Input: [[0,30],[5,10],[15,20]] 
 * 
 * Output: false Example 2:
 * 
 * Input: [[7,10],[2,4]] 
 * 
 * Output: true NOTE: input types have been changed on
 * 
 * April 15, 2019. Please reset to default code definition to get new method
 * signature.
 *
 */
public class MeetingRooms_252 {

    public static void main(String args[]) {
    	
    	MeetingRooms_252 a = new MeetingRooms_252();
    	List<int[]> list = new ArrayList<int[]>();
    		list.add(new int[] {7,10});
    		list.add(new int[] {2,4});
    		System.out.println(a.canAttendMeetings(list.toArray(new int[0][])));
    }
	
	public boolean canAttendMeetings(int[][] intervals) {
    	
    	Arrays.sort(intervals,new Comparator<int[]>() {
    		
    		public int compare(int[]a, int[] b) {
    			
    			return a[0]-b[0];
    		}
    	});
    	
    	
    	for(int i=0;i<intervals.length-1;i++) {
    		
    		if (intervals[i][1]>intervals[i+1][0]) {
    			return false;
    		}
    	}
    	
    	 // [2,4] [7.10]
        //[1] here is referring to end time
        //[0] here is referring to start time. 
        // so for(int i=0;i<internvals.length;i++) {
        
          //  if (intervals[i][1]>intervals[i+1][0]) {
           //  retutn false
    	
    	return true;
    }

}
