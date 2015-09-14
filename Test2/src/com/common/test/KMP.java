package com.common.test;

import java.util.Arrays;

public class KMP {
	static void getNext(char[] T, int[] next){
		int i = 0;
		int j = 1;
		next[1] = 0;
		while(j < T[0]){
			if(0 == i || T[i] == T[j]){
				i++;
				j++;
				next[j] = i;
			}else {
				i = next[i];
			}
		}
		System.out.println(Arrays.toString(next));
	}
	
	static int KMPPos(char[] S, char[] T){
		int i = 1;
		int j = 1;
		int[] next = new int[255];
		getNext(T, next);
		
		while(i < S[0] && j  < T[0]){
			if(0 == j || S[i] == T[j]){
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		
		if(j == T[0]){
			return i + 1 - T[0];
		}
		return 0;
	}
	
	public static void main(String[] args) {
		char[] S = {' ', 'a', 'b' , 'a', 'a', 'c'};
		char[] T = {' ', 'a', 'b', 'a', 'b', 'a', 'a', 'a', 'b', 'a'};
		S[0] = 5;
		T[0] = 9;
		System.out.println(KMPPos(S, T));
	}

}
