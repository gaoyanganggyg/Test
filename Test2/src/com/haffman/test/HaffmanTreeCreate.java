package com.haffman.test;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HaffmanTreeCreate {
	//构造HuffMan树
	public static <T> Node<T> create(List<Node<T>> list) {
		if(null == list) return null;
		while (list.size() > 1) {
			Collections.sort(list);
			Node<T> left = list.get(0);
			Node<T> right = list.get(1);
			Node<T> parent = new Node<>(null, left.getWeight() + right.getWeight());
			parent.setLeft(left);
			parent.setRight(right);
			list.add(parent);
			list.remove(left);
			list.remove(right);
		}
		return list.get(0);
	}
	//HuffMan编码
	public static <T> void code(Node<T> root){
		if(null == root) return;
		if(null != root.getLeft()){
			root.getLeft().setCoding(root.getCoding() + "0");
		}
		if(null != root.getRight()){
			root.getRight().setCoding(root.getCoding()+"1");
		}
		code(root.getLeft());
		code(root.getRight());
	}
	//广度优先遍历HaffMan树
	public static <T> List<Node<T>> search(Node<T> root) {
		if(root == null) return null;
		List<Node<T>> list = new LinkedList<>();
		Queue<Node<T>> queue = new ArrayDeque<>();
		
		queue.offer(root);
		while(! queue.isEmpty()){
			list.add(queue.peek());
			Node<T> node = queue.poll();
			if(null != node.getLeft())
				queue.offer(node.getLeft());
			if(null != node.getRight())
				queue.offer(node.getRight());
		}
		return list;
	}
	
	public static void main(String[] args) {
		String[] data = {"A", "B", "C","D", "E", "F", "G"};
		int[] weight = {5,24,7,17,34,5,13};
		List<Node<String>> list = new LinkedList<>();
		for(int i = 0; i < weight.length; i++){
			list.add(new Node<String>(data[i], weight[i]));
		}
		Node<String> root = create(list);
		code(root);
		List<Node<String>> list2 = search(root);
		for (Node<String> node : list2) {
			System.out.println(node.toString());
		}
	}
}

