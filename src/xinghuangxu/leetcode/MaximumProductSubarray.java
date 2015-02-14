package xinghuangxu.leetcode;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		MaximumProductSubarray mps=new MaximumProductSubarray();
		int[] A={0,-4,-3,0,4,9,-3};
		System.out.println(mps.maxProduct(A));
	}
	
	/*
	 * Online solution
	 */
	 public int maxProduct(int[] A) {
	        if (A == null || A.length == 0) {
	            return 0;
	        }
	        int max = A[0], min = A[0], result = A[0];
	        for (int i = 1; i < A.length; i++) {
	            int temp = max;
	            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
	            System.out.println(max);
	            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
	            if (max > result) {
	                result = max;
	            }
	        }
	        return result;
	    }
	
	public int findMaxProduct(int x,int y, int[] A){
		if(x>=y)return A[x];
		int negCount=0;
		int left=Integer.MAX_VALUE;
		int right=Integer.MIN_VALUE;
		for(int i=x;i<y+1;i++){
			if(A[i]<0){
				if(left>i){
					left=i;
				}
				if(right<i){
					right=i;
				}
				negCount++;
			}
		}
		if(negCount%2==0){
			left=x-1;
			right=y+1;
		}else{
			int leftMul=1;
			int rightMul=1;
			for(int i=x;i<=left;i++){
				leftMul*=Math.abs(A[i]);
			}
			for(int i=right;i<y+1;i++){
				rightMul*=Math.abs(A[i]);
			}
			if(leftMul>rightMul){
				left=x-1;
			}else{
				right=y+1;
			}
		}
		int result=1;
		for(int i=left+1;i<right;i++){
			result*=A[i];
		}
		return result;
	}
	
	
	
	
	/*
	 * My own solution
	 */
	public int maxProduct1(int[] A) {
		int prevZero=-1;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++){
			if(A[i]==0){
				max=Math.max(max, 0);
				if(i-prevZero>1){
					max=Math.max(max, findMaxProduct(prevZero+1, i-1, A));
				}
				prevZero=i;
			}
		}
		if(A.length-prevZero>1){
			max=Math.max(max, findMaxProduct(prevZero+1,A.length-1,A));
		}
		return max;
		
	}
	
	

}
