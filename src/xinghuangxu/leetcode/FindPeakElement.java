package xinghuangxu.leetcode;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement fpe=new FindPeakElement();
		int[] num={1, 2, 3, 1};
		System.out.println(fpe.findPeakElement(num));
	}

	public int findPeakElement(int[] num) {
		int N=num.length;
		if(N==1)return 0;
		if(num[1]<num[0])return 0;
		if(num[N-1]>num[N-2])return N-1;
		for(int i=1;i<N-1;i++){
			if(num[i]>num[i-1]&&num[i]>num[i+1]){
				return i;
			}
		}
		return -1;
	}

}
