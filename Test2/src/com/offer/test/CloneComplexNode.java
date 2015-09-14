package com.offer.test;
/**
 * 复杂链表的复制
 * 
 * 1、可以利用哈希表存储sibling来完成
 * 2、分三步
 * @author Administrator
 *
 */
public class CloneComplexNode {
	public static void main(String[] args) {
	}
	//复制
	static CompelxNode clone(CompelxNode head){
		CompelxNode node = head;
		while(node != null){
			CompelxNode node1 = node.next;
			CompelxNode nextNode = new CompelxNode(node.val);
			node.next = nextNode;
			nextNode.next = node1; 
			node = node1;
		}
		return head;
	}
	//连接
	static CompelxNode connect(CompelxNode head){
		CompelxNode node = head;
		while(node != null){
			CompelxNode currentNode = node;
			CompelxNode nextNode = currentNode.next;
			if(node.sibling != null){
				nextNode.sibling = currentNode.sibling.next;
			}
			node = nextNode.next;
 		}
		return head;
	}
	//拆分
	static CompelxNode reConnect(CompelxNode head){
		CompelxNode node = head;
		CompelxNode cloneHead = null;
		CompelxNode cloned = null;
		if(null != head){
			cloneHead = cloned = node.next;
			node = cloned.next;
		}
		while(node != null){
			CompelxNode cloneNext = node.next;
			cloned.next = cloneNext;
			cloned = cloned.next;
			node.next = cloneNext.next;
			node = node.next;
		}
		return cloneHead;
	}
	
	private static class CompelxNode{
		int val;
		CompelxNode next;
		CompelxNode sibling;
		public CompelxNode(int val) {
			this.val = val;
		}
	}
	
}
