package xinghuangxu.leetcode;

import java.util.Arrays;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int singleNumber(int[] A){
		int result=A[0];
		for(int i=1;i<A.length;i++){
			result^=A[i];
		}
		return result;
	}

}
