package com.graph.test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class T1 {
	static final int SIZE = 4;
	static boolean[] visited = new boolean[SIZE];
	static int[][] vetex = new int[SIZE][SIZE];
	static String[] data = {"V1","V2","V3","V4"};
	/**
	 * 邻接矩阵图的深度优先遍历（递归）
	 * @param vex
	 */
	private static void DFS(int vex) {
		for(int i = 0; i < SIZE; i++){
			if(vetex[vex][i] == 1 && ! visited[i]){
				System.out.println(data[i]);
				visited[i] = true;
				DFS(i);
			}
		}
	}
	/**
	 *  邻接矩阵图的深度优先遍历（非递归）
	 * @param vex
	 */
	private static void DFS1(int vex){
		LinkedList<Integer> list = new LinkedList<>();
			list.add(vex);
			int i = 0;
			while(list.size() != 0){
				int pos = list.get(list.size() - 1);
				for( i = 0 ; i < SIZE; i++){
					if(vetex[pos][i] == 1 && ! visited[i]){
						System.out.println(data[i]);
						list.add(i);
						visited[i] = true;
						break;
					}
				}
				if(i == SIZE){
					list.remove(list.size() - 1);
				}
			}
	}
	/**
	 *  邻接矩阵图的广度优先遍历（非递归）
	 * @param vex
	 */
	private static void BFS(int vex){
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(vex);
		while(! queue.isEmpty()){
			int pos = queue.peek();
			for(int i = 0; i < SIZE; i++){
				if(vetex[pos][i] == 1 && ! visited[i]){
					System.out.println(data[i]);
					visited[i] = true;
					queue.offer(i);
				}
			}
			queue.poll();
		}
	}
	
	public static void main(String[] args) {
		vetex[0][1] = 1;
		vetex[0][2] = 1;
		vetex[2][3] = 1;
		vetex[3][0] = 1;
		DFS(0);
		//DFS1(0);
		//BFS(0);
	}
}
