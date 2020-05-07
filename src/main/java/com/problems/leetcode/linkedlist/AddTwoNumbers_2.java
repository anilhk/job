package com.problems.leetcode.linkedlist;

/**
 * 
 * 2. Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers.
 * 
 * The digits are stored in reverse order and each of their nodes contain a
 * single digit.
 * 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 * 
 * /* this just says add the numbers so just add for example
 * 
 * 1,2,9 0,6,8
 * 
 * if they are the 2 numbers then the output is 1,8,7,1 just add the numbers
 * with carry and u good.
 * 
 * example 2
 * 
 * 1,2,9 6,8
 * 
 * in this case the answer is . 7,0,0,1 just add thats it. hope you got it
 */

public class AddTwoNumbers_2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		int sum = 0;
		int carry = 0;

		while (l1 != null || l2 != null) {

			int val1 = l1 != null ? l1.val : 0;
			int val2 = l2 != null ? l2.val : 0;

			sum = carry + val1 + val2;
			if (sum > 9) {
				carry = 1;
			} else {
				carry = 0;
			}

			current.next = new ListNode(sum % 10);
			current = current.next;

			if (l1 != null) {
				l1 = l1.next;
			}

			if (l2 != null) {
				l2 = l2.next;
			}

		}

		if (carry == 1) {
			current.next = new ListNode(1);
		}

		return dummy.next;

	}

}
