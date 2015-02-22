package xinghuangxu.leetcode;

import java.util.HashSet;

public class FirstMissingPostive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstMissingPostive fmp=new FirstMissingPostive();
		int[] A={1};
		System.out.println(fmp.firstMissingPositive(A));

	}

	public int firstMissingPositive(int[] A) {
		int max=1;
		HashSet<Integer> map=new HashSet<Integer>();
		for(int i=0;i<A.length;i++){
			if(A[i]>max){
				max=A[i];
			}
			map.add(A[i]);
		}
		for(int i=1;i<=max+1;i++){
			if(!map.contains(i)){
				return i;
			}
		}
		return 1;
//		if(A==null)return 0;
//		if(A.length==0)return 1;
//		int N=A.length,sum,missingSum=0;
//		if(N%2==0){
//			sum=(N/2)*(N+1);
//		}else{
//			sum=((N+1)/2)*N;
//		}
//		Integer replacedNum=0;
//		HashSet<Integer> map=new HashSet<Integer>();
//		for(int i=0;i<N;i++){
//			if(A[i]<=0||A[i]>N){
//				replacedNum=A[i];
//			}else {
//				if(map.contains(A[i])){
//					replacedNum=A[i];
//				}else{
//					map.add(A[i]);
//				}
//			}
//			missingSum+=A[i];
//		}
//		missingSum-=replacedNum;
//		return sum-missingSum;
	}

}
