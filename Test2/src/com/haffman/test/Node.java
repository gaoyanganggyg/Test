package com.haffman.test;

public class Node<T> implements Comparable<Node<T>> {
	private T data;
	private int weight;
	private String coding = "";
	private Node<T> left;
	private Node<T> right;

	public Node(T data, int weight){
		this.data = data;
		this.weight = weight;
	}
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}


	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "data: " +  this.getData() + " weight: " +  this.getWeight() + " code: " + this.getCoding();
	}

	@Override
	public int compareTo(Node<T> o) {
		if(this.getWeight() - o.getWeight() > 0)
			return 1;
		else if (this.getWeight() - o.getWeight() == 0) {
			return 0;
		}else {
			return -1;
		}
	}
}
