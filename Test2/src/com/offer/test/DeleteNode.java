package com.offer.test;

public class DeleteNode {
	public static void main(String[] args) {

	}
	
	static void delete_node(ListNode head, ListNode delete){
		if(null == head || null == delete) return;
		if(delete.next != null){
			ListNode temp = delete.next;
			delete.val = temp.val;
			delete.next = temp.next;
		}else if(head == delete){
			head = null;
		}else{
			ListNode temp = head;
			while(temp.next != delete){
				temp = temp.next;
			}
			temp.next = null;
		}
	}
	
	private static class ListNode{
		int val;
		ListNode next;
		@SuppressWarnings("unused")
		public ListNode(int val) {
			this.val = val;
		}
	}
	
}
