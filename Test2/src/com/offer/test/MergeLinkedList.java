package com.offer.test;
/**
 * 合并两个排序的链表
 * @author Administrator
 *
 */
public class MergeLinkedList {
	public static void main(String[] args) {

	}

	static ListNode merge(ListNode one, ListNode two){
		if(null == one) return two;
		if(null == two) return one;
		ListNode temp = null;
		if(one.val <= two.val){
			temp = one;
			temp.next = merge(one.next, two);
		}else {
			temp = two;
			temp.next = merge(one, two.next);
		}
		return temp;
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
