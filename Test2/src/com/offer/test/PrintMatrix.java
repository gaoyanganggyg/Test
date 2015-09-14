package com.offer.test;
/**
 * 顺时针打印矩阵
 * @author Administrator
 *
 */
public class PrintMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		print_matrix(matrix, 4, 4);
	}
	
	static void print_matrix(int[][] matrix, int rows, int colums){
		if(null == matrix || matrix.length == 0) return;
		int start = 0;
		while(start * 2 < rows && start * 2 < colums){
			print(matrix, rows, colums, start++);
		}
	}
	
	static void print(int[][] matrix, int rows, int colums, int start){
		int endX = colums - 1 - start;
		int endY = rows - 1 - start;
		
		for(int i = start; i <= endX; i++){
			print(matrix[start][i]);
		}
		if(start < endY){
			for(int i = start + 1; i <= endY; i++){
				print(matrix[i][endX]);
			}
		}
		if(start < endX && start < endY){
			for(int i = endX - 1; i >= start; i--){
				print(matrix[endY][i]);
			}
		}
		if(start < endX && start < endY - 1){
			for(int i = endY - 1; i > start; i--){
				print(matrix[i][start]);
			}
		}
		
	}
	
	static void print(int num){
		System.out.print(num + " ");
	}
	
}
