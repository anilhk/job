package com.problems.leetcode.linkedlist;

/**
 * 
 * 92. Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * 
 * Output: 1->4->3->2->5->NULL
 *
 *
 * https://www.youtube.com/watch?v=wk8-_M-2fzI
 * 
 * p c n 1->2->3->4->5->NULL
 * 
 * 1->3->2->4->5->null
 * 
 * 
 * 1->4->3->2->5->NULL
 * 
 */
public class ReverseLinkedList2_92 {

	public ListNode reverseBetween(ListNode head, int m, int n) {

		// m = 2 and n = 4

//               m         n
//          1--->2--->3--->4--->5--->NULL

//          p    c    n
//          1--->2--->3--->4--->5--->NULL   

//first pass
//          p         c   n
//          1--->3--->2---4----5---->null     

//second pass         
//          1--->4--->3--->2--->5--->NULL                 

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// now we need to have 3 pointers
		// pre, current, next
		// pre will be m-1;
		// current will be m
		// next = m+1
		ListNode pre = null;
		ListNode current = null;
		ListNode next = null;

		// lets assign pre to dummy and advance pre till m-1;
		pre = dummy;
		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}
		System.out.println(pre.val);

		// current is m.
		current = pre.next;

		// this is reverse
		for (int i = 0; i < n - m; i++) {

			next = current.next;
			current.next = next.next;
			next.next = pre.next;
			pre.next = next;

		}

		return dummy.next;
	}

}
