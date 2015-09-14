package com.offer.test;


/**
 * 链表反转
 * @author Administrator
 *
 */
public class InverseLinkList {
	public static void main(String[] args) {
	}

	static void inverse_linklist(ListNode head) {
		if(null == head) return;
		ListNode next = null;
		while(head.next != null){
			ListNode temp = head;
			ListNode temp1 = head.next;
			
			head.next = next;
			next = temp;
			head = temp1;
		}
	}
	
	//递归实现
	static ListNode inverse_recurse(ListNode head){
		if(head != null && head.next != null){
			ListNode p = head.next;
			ListNode q = inverse_recurse(head.next);
			p.next = head;
			head.next = null;
			return q;
		}
		return head;
	}
	
	

	private static class ListNode {
		@SuppressWarnings("unused")
		int val;
		ListNode next = null;

		@SuppressWarnings("unused")
		ListNode(int val) {
			this.val = val;
		}
	}

}
