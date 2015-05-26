package com.graph.test;

public class Kruslkal {

	 static final int INF = Integer.MAX_VALUE;
	 static char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
	 static int matrix[][] = {
             /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
      /*A*/ {   0,  12, INF, INF, INF,  16,  14},
      /*B*/ {  12,   0,  10, INF, INF,   7, INF},
      /*C*/ { INF,  10,   0,   3,   5,   6, INF},
      /*D*/ { INF, INF,   3,   0,   4, INF, INF},
      /*E*/ { INF, INF,   5,   4,   0,   2,   8},
      /*F*/ {  16,   7,   6, INF,   2,   0,   9},
      /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
	static int SIZE = matrix.length;
	static int SIZE1;
	
	public void kruslkal() {
		int index = 0;
		EData[] edges = getEdge();
		sort(edges);
		int[] venders = new int[SIZE1];
		EData[] rets = new EData[SIZE1]; 
		for(int i = 0; i < SIZE1; i++){
			int p1 = edges[i].start;
			int p2 = edges[i].end;
			int m = getEnd(venders, p1);
			int n = getEnd(venders, p2);
			if(m != n){
				venders[m] = n;
				rets[index++] = edges[i];
			}
		}
		show(rets);
	}
	
	private EData[] getEdge(){
		EData[] datas = new EData[12];
		int index = 0;
		for(int i = 0 ; i < SIZE; i++){
			for(int j = i + 1; j < SIZE; j++){
				if(matrix[i][j] != INF){
					datas[index++] = new EData(i, j, matrix[i][j]);
				}
			}
		}
		SIZE1 = index;
		return datas;
	}
	
	private void sort(EData[] edges){
		for(int i = 0; i < edges.length; i++){
			for(int j = i + 1; j < edges.length; j++){
				if(edges[i].weight > edges[j].weight){
					int temp = edges[i].weight;
					edges[i].weight = edges[j].weight;
					edges[j].weight = temp;
				}
			}
		}
	}
	
	private int getEnd(int[] vends, int i){
		int end = 0;
		for(int j = 0; j < vends.length; j++){
			if(vends[j] != 0){
				end = vends[j];
			}else {
				end = i;
			}
		}
		return end;
	}
	
	private void show(EData[] edge){
		for (int i = 0; i < edge.length; i++) {
			System.out.printf("(%c,%c) %d", vexs[edge[i].start], vexs[edge[i].end], edge[i].weight);
			System.out.println();
		}
	}

	private static class EData {
		int start;
		int end;
		int weight;
		public EData(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		Kruslkal kruslkal = new Kruslkal();
		kruslkal.kruslkal();
	}

}
