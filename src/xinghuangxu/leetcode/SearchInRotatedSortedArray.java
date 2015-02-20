package xinghuangxu.leetcode;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] num = {1,3,1,1,1 };
		SearchInRotatedSortedArray s=new SearchInRotatedSortedArray();
		System.out.println(s.search(num, 3));
	}
	
	public boolean search(int[] A, int target) {
		return binarySearch(A,0,A.length-1,target);
	}
	
	private boolean binarySearch(int[] a, int i, int j,int target) {
		if(i>j)return false;
		int mid=(i+j)/2,temp=a[mid];
		if(temp==target)return true;
		//left side sorted
		if(a[i]<=a[mid]){
			if(target>=a[i]&&target<=a[mid]){
				return binarySearch(a,i,mid-1,target);
			}else{
				return binarySearch(a,mid+1,j,target);
			}
		}
		//right side sorted
		if(a[j]>=a[mid]){
			if(target<=a[j]&&target>=a[mid]){
				return binarySearch(a,mid+1,j,target);
			}else{
				return binarySearch(a,i,mid,target);
			}
		}
		return false;
	}
	
	/*
	 * Binary Search Solution
	 
	public int search(int[] A, int target) {
		return binarySearch(A,0,A.length-1,target);
	}
	
	private int binarySearch(int[] a, int i, int j,int target) {
		if(i>j)return -1;
		int mid=(i+j)/2,temp=a[mid];
		if(temp==target)return mid;
		//left side sorted
		if(a[i]<=a[mid]){
			if(target>=a[i]&&target<a[mid]){
				return binarySearch(a,i,mid-1,target);
			}else{
				return binarySearch(a,mid+1,j,target);
			}
		}
		//right side sorted
		if(a[j]>=a[mid]){
			if(target<=a[j]&&target>=a[mid+1]){
				return binarySearch(a,mid+1,j,target);
			}else{
				return binarySearch(a,i,mid,target);
			}
		}
		return -1;
	}
*/
	/*
	 * O(n) solution
	 */
	public int search2(int[] A, int target) {
		for (int i = 0; i < A.length; i++) {
			if(A[i]==target){
				return i;
			}
		}
		return -1;
	}

}
