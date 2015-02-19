package xinghuangxu.leetcode;

public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		SearchInRotatedSortedArrayII ssa=new SearchInRotatedSortedArrayII();
		int[] A={1,3,1,1,1};
		int target=3;
		System.out.println(ssa.search(A, target));
		// TODO Auto-generated method stub

	}
	
	 public boolean search(int[] A, int target) {
			return binarySearch(A,0,A.length-1,target);
		}
		
		private boolean binarySearch(int[] a, int i, int j,int target) {
			if(i>j)return false;
			int mid=(i+j)/2,temp=a[mid];
			if(temp==target)return true;
			if(a[i]<=a[mid]&&a[j]>=a[mid]){
				return binarySearch(a,i,mid-1,target)||binarySearch(a,mid+1,j,target);
			}
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
					return binarySearch(a,i,mid-1,target);
				}
			}
			return false;
		}

}
