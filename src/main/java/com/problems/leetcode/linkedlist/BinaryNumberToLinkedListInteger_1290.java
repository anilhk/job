package com.problems.leetcode.linkedlist;

import java.util.Stack;

/**
 * 
 * 1290. Convert Binary Number in a Linked List to Integer
 * 
 * Given head which is a reference node to a singly-linked list. The value of
 * each node in the linked list is either 0 or 1. The linked list holds the
 * binary representation of a number.
 * 
 * Return the decimal value of the number in the linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,0,1] 
 * Output: 5 
 * 
 * Explanation: (101) in base 2 = (5) in base 10
 * 
 * Example 2:
 * 
 * Input: head = [0] 
 * Output: 0 Example 3:
 * 
 * Input: head = [1] 
 * Output: 1 Example 4:
 * 
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0] 
 * Output: 18880 
 * 
 * Example 5:
 * 
 * Input: head = [0,0] 
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * The Linked List is not empty. Number of nodes will not exceed 30. Each node's
 * value is either 0 or 1.
 *
 *
 */
public class BinaryNumberToLinkedListInteger_1290 {

	
	  public int getDecimalValue(ListNode head) {
		  
		  Stack<Integer> stack = new Stack<Integer>();
		  
		  ListNode temp = head;
		  
		  // push all elements in stack so number 100 input will be stored as 
		  // 1 0 0 : 
		  while(temp != null) {
			  
			  stack.push(temp.val);
			  temp = temp.next;
		  }
		  
		    //    100 =  0 * 2 raise to 0 + 0*2 raise to 1 + 1 * 2 raise to 2 = 0 + 0 + 4 = 4 

		  int sum = 0;
		  int i =0;
		  while(!stack.isEmpty()) {
			  
			  // 0 will come out first LIFO
			  int value = stack.pop();
			  sum = (int) (sum + value * (int)Math.pow(2, i));
			  System.out.println("sum is " +sum);
			  i++;
		  }
	  
		  return sum;
	  }
}
