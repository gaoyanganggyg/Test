package com.common.test;


public class ReverseList {
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(4);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		reverse(listNode1);
	}
	public static ListNode reverse(ListNode node) {
		if(null == node) return null;
		ListNode temp = null;
		while(node.next != null){
			ListNode temp1 = node.next;
			node.next = temp;
			temp = node;
			node = temp1;
		}
		node.next = temp;
		return node;
	}
	
	 static class ListNode {
			int val;
			ListNode next;

			ListNode(int x) {
				val = x;
			}
		}
}
