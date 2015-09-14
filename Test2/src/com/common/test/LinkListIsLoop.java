package com.common.test;

public class LinkListIsLoop {
	public static void main(String[] args) {
		
	}
	
	static boolean is_loop(ListNode head){
		if(null == head) return false;
		ListNode slow = head;
		ListNode fast = head;
		while(slow != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
		return !(slow == null || fast == null);
	}
	
	private static class ListNode{
		@SuppressWarnings("unused")
		int val;
		ListNode next;
		@SuppressWarnings("unused")
		public ListNode(int val) {
			this.val = val;
		}
	}
	
}
