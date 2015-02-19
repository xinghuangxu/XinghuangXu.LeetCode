package xinghuangxu.leetcode;

public class MergeSortedArray {

	public static void main(String[] args) {
		MergeSortedArray msa=new MergeSortedArray();
		int[] A={1,2,4,5,6,3};
		int[] B={3};
		msa.merge(A, 5, B, 1);
		for(int i:A){
			System.out.println(i);
		}
	}

	public void merge(int A[], int m, int B[], int n) {
		for(int i=m-1;i>-1;i--){
			A[i+n]=A[i];
		}
		int p1=n,p2=0,index=0;
		while(p1<n+m&&p2<n){
			if(A[p1]<B[p2]){
				A[index]=A[p1];
				p1++;
			}else{
				A[index]=B[p2];
				p2++;
			}
			index++;
		}
		while(p1<n+m){
			A[index]=A[p1];
			p1++;
			index++;
		}
		while(p2<n){
			A[index]=B[p2];
			p2++;
			index++;
		}
	}

}
