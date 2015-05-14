package com.graph.test;

public class T2 {
	static final int SIZE = 4;
	static boolean[] visted = new boolean[SIZE];
	
	public static void main(String[] args) {
		Edge e13 = new Edge(2, null);
		Edge e12 = new Edge(1, e13);
		Node v1 = new Node("V1", e12);
		Node v2 = new Node("V2", null);
		Edge e34 = new Edge(3, null);
		Node v3 = new Node("V3", e34);
		Edge e41 = new Edge(0, null);
		Node v4 = new Node("V4", e41);
		
		
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

