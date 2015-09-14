package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * @author Administrator
 *
 */
public class _234_15811_PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
			int a = list.get(i);
			int b = list.get(j);
			if (a != b)
				return false;
		}
		return true;
	}
	
	public boolean isPalindrome1(ListNode head) {
		if(null == head) return true;
		ListNode slow = head;
		ListNode fast = head;
		
		while(null != fast.next && null != fast.next.next){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode last = slow.next;
		ListNode pre = head;
		while(null != last && null != last.next){
			ListNode temp = last.next;
			last.next = temp.next;
			temp.next = slow.next;
			slow.next = temp;
        }
			
		while(null != slow.next){
			slow = slow.next;
			if(pre.val != slow.val) return false;
			pre = pre.next;
		}
		return true;
	}
}
