package xinghuangxu.leetcode;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		MedianOfTwoSortedArrays median=new MedianOfTwoSortedArrays();
		int[] A={2,3};
		int[] B={1,4};
		System.out.println(median.findMedianSortedArrays(A, B));
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		int m=A.length,n=B.length;
		if((m+n)%2==0){
			return (findMedian(A,B,0,m-1,0,n-1,(m+n)/2)+findMedian(A,B,0,m-1,0,n-1,(m+n)/2-1))/2;
		}else{
			return findMedian(A,B,0,m-1,0,n-1,(m+n)/2);
		}
	}
	
	public double findMedian(int a[],int b[],int aStart, int aEnd,int bStart, int bEnd, int k){
		int aLen=aEnd-aStart +1;
		int bLen=bEnd-bStart+1;
		if(aLen==0){
			return b[k+bStart];
		}
		if(bLen==0){
			return a[aStart+k];
		}
		if(k==0){
			return a[aStart]<b[bStart]?a[aStart]:b[bStart];
		}
		int aMid=aLen*k/(aLen+bLen);
		int bMid=k-1-aMid;
		
		aMid=aMid+aStart;
		bMid=bMid+bStart;
		
		if(a[aMid]==b[bMid]){
			return a[aMid];
		}else if(a[aMid]>b[bMid]){
			k=k-(bMid-bStart+1);
			aEnd=aMid;
			bStart=bMid+1;
			
		}else{
			k=k-(aMid-aStart+1);
			bEnd=bMid;
			aStart=aMid+1;
		}
		return findMedian(a, b, aStart, aEnd, bStart, bEnd, k);
	}

//	public double findMedianSortedArrays(int A[], int B[]) {
//		return findMedian(A, B, 0, A.length-1);
//	}
//	
//	public double findMedian(int a1[],int a2[],int left, int right){
//		if(left>right||a1.length==0){
//			return findMedian(a2, a1, 0, a2.length-1);
//		}
//		int i=(left+right)/2;
//		int j=(a1.length+a2.length)/2-i-1;
//		if(a1[i]==a2[j])return a1[i];
//		if((a1[i] > a2[j]) && (j==a2.length-1 || a1[i]<=a2[j+1])){
//			if((a1.length+a2.length) %2==0){
//				return (a1[i]+a2[j])/2.0;
//			}
//			return a1[i];
//		}else if(a1[i]>a2[j]){
//			return findMedian(a1, a2, left, i-1);
//		}else{
//			return findMedian(a1, a2, i+1, right);
//		}
//	}

}
