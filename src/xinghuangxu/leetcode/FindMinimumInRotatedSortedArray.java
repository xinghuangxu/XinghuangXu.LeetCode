package xinghuangxu.leetcode;

public class FindMinimumInRotatedSortedArray {
	
	public static void main(String[] arg) {
		FindMinimumInRotatedSortedArray fmrsa=new FindMinimumInRotatedSortedArray();
		int[] num={1,1};
		System.out.println(fmrsa.findMin(num));
	}

	public int findMin(int[] num) {
		int N=num.length;
		if(N==1)return num[0];
		for(int i=0;i<num.length;i++){
			if(num[i]>num[(i+1)%(N)]){
				return num[(i+1)%(N)];
			}
		}
		return num[0];
	}
}
