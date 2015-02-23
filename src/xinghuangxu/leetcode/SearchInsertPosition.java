package xinghuangxu.leetcode;

public class SearchInsertPosition {

	public static void main(String[] args) {
		SearchInsertPosition sip=new SearchInsertPosition();
		int[][] list={
				{1,3,5,6},
				{1,3,5,6},
				{1,3,5,6},
				{1,3,5,6},
				{1}
		};
		int[] target={5,2,7,0,1};
		for(int i=0;i<list.length;i++){
			System.out.println(sip.searchInsert(list[i], target[i]));
		}
		
	}
	
	 public int searchInsert(int[] A, int target) {
	        for(int i=0;i<A.length;i++){
	        	if(A[i]>=target)return i;
	        }
	        return A.length;
	    }

}
