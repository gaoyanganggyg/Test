package com.graph.test;

public class MatrixUDG {
	private static final int INF = Integer.MAX_VALUE;
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
     static final int SIZE = matrix.length; 
     static boolean[] visited = new boolean[SIZE];
     static int[] weight = new int[SIZE];
     static char[] primes = new char[SIZE];
     
	public static void prime(int start) {
		int index = 0;
		primes[index++] = vexs[start];
		for(int i = 0; i < SIZE; i++){
			if(! visited[start]){
				for(int j = 0; j < SIZE; j++){
					weight[j] = matrix[start][j];
				}
				weight[start] = 0;
				int min = INF;
				int minInt = 0;
				int k = 0;
				for( k = 0; k < SIZE; k++){
					if(weight[k] != 0 && weight[k] < min){
						min = weight[k];
						minInt = k;
					}
				}
				primes[index++] = vexs[minInt];
				weight[minInt] = 0;
				for(k = 0; k < SIZE; k++){
					if(weight[k] != 0 && matrix[minInt][k] < weight[k]){
						weight[k] = matrix[minInt][k];
					}
				}
			}
		}
	}

}
