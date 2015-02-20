package xinghuangxu.leetcode;

public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix={
				{1}
//		                {1,   3,  5,  7},
//		                {10, 11, 16, 20},
//		                {23, 30, 34, 50}
		};
		Search2DMatrix sm=new Search2DMatrix();
		System.out.println(sm.searchMatrix(matrix,2));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null||matrix.length==0)return false;
		int m=matrix.length,n=matrix[0].length;
		int[] temp  = m==1?matrix[0]:findRow(matrix,target,0,m-1,n-1);
		if(temp==null)return false;
		return binarySearch(temp,target,0,n-1);
	}

	private boolean binarySearch(int[] temp, int target,int lo,int hi) {
		if(lo>hi)return false;
		int mid=(lo+hi)/2;
		if(temp[mid]==target){
			return true;
		}else if(temp[mid]>target){
			return binarySearch(temp,target,lo,mid-1);
		}else{
			return binarySearch(temp,target,mid+1,hi);
		}
	}

	private int[] findRow(int[][] matrix, int target,int lo,int hi,int n) {
		if(lo>hi)return null;
		int mid=(lo+hi)/2;
		int min=matrix[mid][0];
		int max=matrix[mid][n];
		if(target>=min&&target<=max){
			return matrix[mid];
		}else if(min>target){
			return findRow(matrix,target,lo,mid-1,n);
		}else{
			return findRow(matrix,target,mid+1,hi,n);
		}
	}

}
