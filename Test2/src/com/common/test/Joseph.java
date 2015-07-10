package com.common.test;


public class Joseph {
	static ListNode head = new ListNode(1);
	static int  size = 5;
	static {
		ListNode temp = head;
		for (int i = 2; i <= 6; i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		temp.next = head;
	}

	static class ListNode {
		int num;
		ListNode next;

		public ListNode(int num) {
			this.num = num;
		}
	}

	public static void main(String[] args) {
		//System.out.println(joseph(head).num);
		System.out.println(joseph1(new int[]{1,2,3,4,5,6}));
	}
	
	public static ListNode joseph(ListNode head) {
		int count = 0;
		ListNode preNode = head;
		while(head.next != head){
			if(++count == size){
				count = 0;
				preNode.next = head.next;
				System.out.println(head.num);
			}else {
				preNode = head;
			}
			head = head.next;
		}
		return head;
	}
	
	static int pos = 0;
	public static int joseph1(int[] array) {
		int length = array.length;
		boolean[] isOut = new boolean[array.length];
		int count = 0;
		int count1 = 0;
		while(count != length - 1){
			if(! isOut[pos] && ++count1 == size){
				isOut[pos] = true;
				System.out.println(pos + 1);
				count1 = 0;
				count++;
			}
			if(++pos == length){
				pos = 0;
			}
		}
		System.out.println("---------------");
		int j = 0;
		for(; j < length; j++){
			if(!isOut[j]) break;
		}
		return j + 1;
	}
	
}
