package com.leetcode.test;

/**
 * Reverse a singly linked list
 * 
 * @author Administrator
 *
 */
public class _206_ReverseLinkedList {
	//递归 288ms
	public static ListNode reverseList(ListNode head) {
		ListNode result;
		if(head == null || head.next == null){
			return head;
		}else {
			ListNode temp = head;
			ListNode tempNext = head.next;
			head.next = null;
			result = reverseList(tempNext);
			tempNext.next = temp;
		}
		return result;
	}
	//非递归 260ms
	public static ListNode reverseList1(ListNode head) {
		if(null == head || head.next == null) return head;
		ListNode temp = null;
		while (head.next != null) {
			ListNode temp1 = head.next;
			head.next = temp;
			temp = head;
			head = temp1;
		}
		head.next = temp;
		return head;
	}

	public static void main(String[] args) {

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
