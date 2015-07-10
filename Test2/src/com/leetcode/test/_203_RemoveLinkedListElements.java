package com.leetcode.test;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 * 
 * @author Administrator
 *
 */
public class _203_RemoveLinkedListElements {
	public static ListNode removeElements(ListNode head, int val) {
		ListNode temp = head;
		ListNode tempHead = head;
		while(head != null){
			if(head.val == val){
				if(head == temp){
					tempHead = head.next;
					head = tempHead;
					temp = head;
				}else {
					temp.next = head.next;
					head = head.next;
				}
			}else {
				temp = head;
				head = head.next;
			}
		}
		
		return tempHead;
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
 