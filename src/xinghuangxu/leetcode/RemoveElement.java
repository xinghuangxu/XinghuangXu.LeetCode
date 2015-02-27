package xinghuangxu.leetcode;

public class RemoveElement {

	public static void main(String[] args) {
		RemoveElement re=new RemoveElement();
		int[] A={1,4,3,6,7,3,8,9};
		int rel=re.removeElement(A, 3);
		System.out.println(rel);
	}

	public int removeElement(int[] A, int elem) {
		int k=0,end=A.length-1;
		while(k<=end){ //need to process k==end because its to return the new length
			if(A[k]!=elem){
				k++;
			}else{
				swap(A,k,end);
				end--;
			}
		}
		return k;
	}

	private void swap(int[] a, int k, int end) {
		int temp=a[k];
		a[k]=a[end];
		a[end]=temp;
	}

}
