package com.leetcode.test;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author Administrator
 *
 */
public class _21_MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		l2.next = l3;
		l3.next = l4;
		
		mergeTwoLists(l1, l2);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(null == l1) return l2;
		if(null == l2) return l1;
		ListNode node =  new ListNode(0);
		ListNode tail  = null;
		boolean isHead = true;
		while(l1 != null && l2 != null){
			if(l1.val >= l2.val){
				if(isHead){
					node.val = l2.val;
					isHead = false;
					tail = node;
				}else {
					ListNode temp = new ListNode(l2.val);
					tail.next = temp;
					tail = temp;
				}
				l2 = l2.next;
			}else {
				if(isHead){
					node.val = l1.val;
					isHead = false;
					tail = node;
				}else {
					ListNode temp = new ListNode(l1.val);
					tail.next = temp;
					tail = temp;
				}
				l1 = l1.next;
			}
		}
		
		while(l1 != null){
			tail.next = l1;
			tail = l1;
			l1 = l1.next;
		}
		while(null != l2){
			tail.next = l2;
			tail = l2;
			l2 = l2.next;
		}
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
