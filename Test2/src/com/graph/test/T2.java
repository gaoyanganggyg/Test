package com.graph.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class T2 {
	static final int SIZE = 4;
	static boolean[] visted = new boolean[SIZE];
	static List<Node> list = new ArrayList<>();
	static Queue<Integer> queue = new ArrayDeque<>();
	
	/**
	 * 图的邻接表广度优先搜索
	 */
	private static void BFS(){
		queue.offer(0);
			while(queue.size() != 0){
				if(! visted[queue.peek()]){
					Node node = list.get(queue.peek());
					System.out.println(node.data);
					visted[queue.poll()] = true;
					Edge edge = node.next;
					while(edge != null){
						queue.offer(edge.vex);
						edge = edge.next;
					}
				}
			}
	}
	
	public static void main(String[] args) {
		Edge e13 = new Edge(2, null);
		Edge e12 = new Edge(1, e13);
		Node v1 = new Node("V1", e12);
		Node v2 = new Node("V2", null);
		Edge e34 = new Edge(3, null);
		Node v3 = new Node("V3", e34);
		Edge e41 = new Edge(0, null);
		Node v4 = new Node("V4", e41);
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		BFS();
	}
}

class Node{
	String data;
	Edge next;
	public Node(String data, Edge next){
		this.data = data;
		this.next = next;
	}
}

class Edge{
	int vex;
	Edge next;
	public Edge(int vex, Edge next){
		this.vex = vex;
		this.next = next;
	}
}

