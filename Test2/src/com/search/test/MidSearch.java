package com.search.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class MidSearch {
	private static void midSearch(Node root) {
		if (null == root)
			return;
		midSearch(root.getLeft());
		System.out.println(root.getData());
		midSearch(root.getRight());
	}

	private static void preSearch(Node root) {
		if(null == root) return;
		System.out.println(root.getData());
		preSearch(root.getLeft());
		preSearch(root.getRight());
	}

	private static void afterSearch(Node root) {
		if(null == root) return;
		afterSearch(root.getLeft());
		afterSearch(root.getRight());
		System.out.println(root.getData());
	}
	
	private static void widthSearch(Node root){
		if(null == root) return;
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(root);
		while(queue.size() != 0){
			Node node = queue.peek();
			System.out.println(queue.poll().getData());
			if (null != node.getLeft()) {
				queue.add(node.getLeft());
			}
			if (null != node.getRight()) {
				queue.add(node.getRight());
			}
		}
 	}

	public static void main(String[] args) {
		Node n6 = new Node(2, null, null);
		Node n5 = new Node(5, null, null);
		Node n4 = new Node(4, null, null);
		Node n3 = new Node(7, null, n6);
		Node n2 = new Node(1, n4, n5);
		Node n1 = new Node(3, n2, n3);
		midSearch(n1);
		System.out.println("-----------------");
		preSearch(n1);
		System.out.println("-----------------");
		afterSearch(n1);
		System.out.println("-----------------");
		widthSearch(n1);
	}
}
