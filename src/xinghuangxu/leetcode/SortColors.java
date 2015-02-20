package xinghuangxu.leetcode;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={0,0};
		SortColors sc=new SortColors();
		sc.sortColors(A);
		System.out.println();
	}
	
	/*
	 * Swap instead of replace
	 */
	public void sortColors(int[] A) {
		if(A==null||A.length<=1)return ;
        int N=A.length,zero=0,second=N-1;
        for(int i=0;i<=second;i++){
        	if(A[i]==2){
        		swap(i,second,A);
        		second--;
        		i--;
        	}else
        	if(A[i]==0){
        		swap(i,zero,A);
        		zero++;
        	}
        }
    }

	private void swap(int i, int j, int[] a) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

}
