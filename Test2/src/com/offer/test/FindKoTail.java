package com.offer.test;
/**
 * 链表中倒数第k个节点
 * @author Administrator
 *
 */
public class FindKoTail {
	public static void main(String[] args) {

	}
	
	static ListNode find(ListNode head, int k){
		if(null == head || 0 == k) return null;
		ListNode aHead = head;
		ListNode behind = head;
		for(int i = 0; i < k - 1; i++){
			if(aHead.next != null){
				aHead = aHead.next;
			}else {
				return null;
			}
		}
		
		while(behind.next != null){
			behind = behind.next;
			aHead = aHead.next;
		}
		return behind;
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
