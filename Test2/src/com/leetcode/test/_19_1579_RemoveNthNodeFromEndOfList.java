package com.leetcode.test;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * @author Administrator
 *
 */
public class _19_1579_RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode returnHead = removeNthFromEnd(n1, 4);
		while (returnHead != null) {
			System.out.println(returnHead.val);
			returnHead = returnHead.next;
		}

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (null == head)
			return null;
		int len = 0;
		ListNode tempNode = head;
		while (null != tempNode) {
			len++;
			tempNode = tempNode.next;
		}
		if (1 == n && len == 1 || n == len)
			return head.next;
		if (n > len)
			return head;
		tempNode = head;
		int count = 0;
		ListNode pre = null;
		while (count != len - n) {
			pre = tempNode;
			count++;
			tempNode = tempNode.next;
		}
		pre.next = tempNode.next;
		return head;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
