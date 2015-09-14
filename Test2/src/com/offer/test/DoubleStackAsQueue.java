package com.offer.test;

import java.util.Stack;
/**
 * 利用两个栈实现队列
 * @author Administrator
 *
 */
public class DoubleStackAsQueue {
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {

	}

	static void push(int node) {
		stack1.push(node);
	}

	static int pop() {
		if(stack2.size() <= 0){
			while(stack1.size() > 0){
				int data = stack1.pop();
				stack2.push(data);
			}
		}
		if(stack2.size() == 0) return -1;
		return stack2.pop();
	}

}
