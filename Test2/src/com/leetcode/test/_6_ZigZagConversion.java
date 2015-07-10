package com.leetcode.test;

/**
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 * @author Administrator
 *
 */
public class _6_ZigZagConversion {
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3)); //PAHNAPLSIIGYIR
	}
	
	 public  static String convert(String s, int numRows) {
		 if(null == s || "".equals(s.trim()) || 1 == numRows || numRows >= s.length()) return s;
		 int step = (numRows - 1) * 2;
		 int originStep = step;
		 StringBuilder sbBuilder = new StringBuilder();
		 int count  = 0;
		 while(count < numRows){
			 String charI = s.charAt(count) + "";
			 sbBuilder.append(charI);
			 int temp = step;
			 for(int i = count + step; i < s.length();){
				if(temp != 0){
					sbBuilder.append(s.charAt(i) + "");
				}
				 temp = originStep - temp;
				 i += temp;
			 }
			 step -= 2;
			 count++;
		 }
		 return sbBuilder.toString();
	 }
}
