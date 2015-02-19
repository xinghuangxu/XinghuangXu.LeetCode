package xinghuangxu.leetcode;

public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesFromSortedArrayII rdfa = new RemoveDuplicatesFromSortedArrayII();
		int[] A={1,1,1,2,2,3};
		System.out.println(rdfa.removeDuplicates(A));
		System.out.println();
	}
	
	public int removeDuplicates(int[] A){
		int n=A.length;
		if(n<=2)return n;
		int len=2;
		for(int i=2;i<n;i++){
			if(A[len-2]!=A[i]){
				A[len++]=A[i];
			}
		}
		return len;
	}
	
	/*
	 * use buffer
	 */
	public int removeDuplicates3(int[] A) {
		if(A.length<3)return A.length;
		int count=1,repeat=1,cur=A[0];
		for(int i=1;i<A.length;i++){
			if(cur==A[i]){
				repeat++;
				if(repeat<3){
					A[count]=A[i];
					count++;
				}
			}else{
				repeat=1;
				cur=A[i];
				A[count]=A[i];
				count++;
			}
		}
		return count;
	}
	
	/*
	 * Use array to copy
	 */
	public int removeDuplicates1(int[] A) {
		int count=0;
		int[] B=new int[A.length];
		for(int i=0;i<A.length;i++){
			if(i<2||(i-2>=0&&A[i-2]!=A[i])){
				B[count]=A[i];
				count++;
			}
		}
		for(int i=0;i<B.length;i++){
			A[i]=B[i];
		}
		return count;
	}

}
