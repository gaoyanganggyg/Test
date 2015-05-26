package com.leetcode.test;

/**
 * You are given two linked lists representing two non-negative numbers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit. 
 *  Add the two numbers and return it as a linked list.
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 * @author Administrator
 *
 */
public class AddTwoNum {
	public static void main(String[] args) {
		ListNode a1 = new ListNode(5);
//		ListNode a2 = new ListNode(4);
//		ListNode a3 = new ListNode(3);
//		a3.next = null;
//		a2.next = a3;
		a1.next = null;
		
		ListNode b1 = new ListNode(5);
//		ListNode b2 = new ListNode(6);
//		ListNode b3 = new ListNode(4);
//		b3.next = null;
//		b2.next = b3;
		b1.next = null;
		
		ListNode nodeListNode = addTwoNumbers(a1, b1);
		while(null != nodeListNode){
			System.out.println(nodeListNode.val);
			nodeListNode = nodeListNode.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(-1);
		ListNode listNode  = null;
		
		ListNode listResult  = null;
		boolean tag = false;
		
		int flag = 0;
		while(l1 != null && l2 != null){
			
			int r1 = l1.val;
			int r2 = l2.val;
			if(r1 + r2 + flag - 10 >= 0){ //进位
				 listNode = new ListNode(r1 + r2 + flag - 10);
				 flag = 1;
			}else {
				 listNode = new ListNode(r1 + r2 + flag );
				 flag = 0;
			}
			
			temp.next = listNode;
			temp = listNode;
			
			if(!tag){ //保存头结点
				listResult = listNode;
				tag = true;
			}
			
			l1 = l1.next;
			l2 = l2.next;
		}
	
		if(null != l1){
			while(null != l1){
				if(l1.val + flag - 10 >= 0){
					listNode = new ListNode(l1.val + flag - 10);
					flag = 1;
				}else {
					listNode = new ListNode(l1.val + flag);
					flag = 0;
				}
				temp.next = listNode;
				temp = listNode;
				
				if(!tag){
					listResult = listNode;
					tag = true;
				}
				
				l1 = l1.next;
			}
		}
		if(null != l2){
			while(null != l2){
				if(l2.val + flag - 10 >= 0){
					listNode = new ListNode(l2.val + flag - 10);
					flag = 1;
				}else {
					listNode = new ListNode(l2.val + flag);
					flag = 0;
				}
				temp.next = listNode;
				temp = listNode;
				
				if(!tag){
					listResult = listNode;
					tag = true;
				}
				
				l2 = l2.next;
			}
		}
		
		if(flag == 1){ //最高位进位
			listNode.next = new ListNode(1);
		}
		
		return listResult;
    }
}

class ListNode{
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
