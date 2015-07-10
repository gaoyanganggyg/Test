package com.leetcode.test;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * Rectangle Area Assume that the total area is never beyond the maximum
 * possible value of int.
 * 
 * @author Administrator
 *
 */
public class _223_RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int width = 0;
		int height = 0;
		
		
		
		if(E >= A ){
			if(E <= C){
				width = C - E;
			}else {
				return 0;
			}
		}
		if(A >= E){
			if(A <= G){
				width = G - A;
			}else {
				return 0;
			}
		}
		
		if(B >= F){
			if(B <= H){
				height = H - B;
			}else {
				return 0;
			}
		}
		if(F >= B){
			if(F <= D){
				height = D - F;
			}else {
				return 0;
			}
		}
		return width * height;
	}

	public static void main(String[] args) {
		System.out.println(computeArea(0,0,0,0,-1,-1,1,1));
	}
}
