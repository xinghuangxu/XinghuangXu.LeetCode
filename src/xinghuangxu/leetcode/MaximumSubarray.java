package xinghuangxu.leetcode;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] num={-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubarray ms=new MaximumSubarray();
		System.out.println(ms.maxSubArray(num));
	}

	/*
	 * This is the O(n) solution
	 */
	public int maxSubArray2(int[] A) {
		int maxEndHere=A[0],maxEndPrev=A[0],max=A[0];
		for(int i=1;i<A.length;i++){
			maxEndHere=Math.max(A[i], A[i]+maxEndPrev);
			maxEndPrev=maxEndHere;
			max=Math.max(max, maxEndHere);
		}
		return max;
	}
	
	/*
	 * divide and conquer solution
	 */
	public int maxSubArray(int[] A){
		return findMaxSubArray(A,0,A.length-1);
	}

	private int findMaxSubArray(int[] a, int lo, int hi) {
		if(lo>hi)return Integer.MIN_VALUE;
		int mid=(lo+hi)/2;
		int left=findMaxSubArray(a, lo, mid-1);
		int right=findMaxSubArray(a, mid+1, hi);
		int leftCrossMax=a[mid],rightCrossMax=0;
		int leftSum=a[mid],rightSum=0;
		for(int i=mid-1;i>=lo;i--){
			leftSum+=a[i];
			if(leftSum>leftCrossMax){
				leftCrossMax=leftSum;
			}
		}
		for(int i=mid+1;i<=hi;i++){
			rightSum+=a[i];
			if(rightSum>rightCrossMax){
				rightCrossMax=rightSum;
			}
		}
		int crossSum=leftCrossMax+rightCrossMax;
		return Math.max(Math.max(left,right), crossSum);
	}

}
