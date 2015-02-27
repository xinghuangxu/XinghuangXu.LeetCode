package xinghuangxu.leetcode;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] A={1,1,2,2};
		RemoveDuplicatesFromSortedArray r=new  RemoveDuplicatesFromSortedArray();
		int rel=r.removeDuplicates(A);
		System.out.println(rel);
	}
	
	public int removeDuplicates(int[] A) {
		if(A==null || A.length==0)return 0; //Array can be empty
        int val=A[0],i=1;
        for(int k=1;k<A.length;k++){
        	if(A[k]!=val){
        		A[i]=A[k]; //should not be swap but replace!!!
        		i++;
        		val=A[k];
        	}
        }
        return i;
    }

	private void swap(int[] a, int k, int i) {
		if(k!=i){
			int temp=a[k];
			a[k]=a[i];
			a[i]=temp;
		}
	}

}
