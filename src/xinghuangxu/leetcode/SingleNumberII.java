package xinghuangxu.leetcode;

public class SingleNumberII {

	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int[] A = { -401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555 };
		int rel = sn.singleNumber(A);
		System.out.println(rel);
	}
	
	public int singleNumber(int[] A) {
		int ones = 0, twos = 0,common_bits=0;
		for (int i = 0; i < A.length; i++) {
			twos|=ones&A[i];
			ones=ones^A[i];
			common_bits=ones&twos;
			ones=ones&~common_bits;
			twos=twos&~common_bits;
		}
		return ones;
	}

	public int singleNumber3(int[] A) {
		int x, sum,result=0,negCount=0;
		x=1<<31;
		for(int i=0;i<A.length;i++){
			if(A[i]<0){
				A[i]=A[i]& (~x);
				negCount++;
			}
		}
		for (int i = 0; i < Integer.SIZE; i++) {
			x = 1 << i;
			sum = 0;
			for (int j = 0; j < A.length; j++) {
				if ((x & A[j]) > 0) {
					sum++;
				}
			}
			if(sum%3>0)
				result |= x;
		}
		if(negCount%3>0){
			return result^ (~ 1<<31);
		}
		return result;
	}

	public int singleNumber1(int[] A) {
		int ones = 0, twos = 0;
		for (int i = 0; i < A.length; i++) {
			ones = (ones ^ A[i]) & ~twos;
			twos = (twos ^ A[i]) & ~ones;
		}
		return ones;
	}

}
