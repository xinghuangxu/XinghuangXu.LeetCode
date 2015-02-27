package xinghuangxu.leetcode;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		DivideTwoIntegers dti=new DivideTwoIntegers();
		System.out.println(dti.divide(10, 3));
	}

	public int divide(int dividend, int divisor) {
		long result=divideLong(dividend,divisor);
		return result>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)result;
	}

	private long divideLong(long dividend, long divisor) {
		int sign=1;
		if((dividend>0&&divisor<0) ||( dividend<0&&divisor>0)){
			sign=-1;
		}
		long lDividend=Math.abs(dividend);
		long lDivisor=Math.abs(divisor);
		if(lDividend<lDivisor)return 0;
		
		long divide=1,sum=lDivisor;
		if(divisor==0)return Integer.MAX_VALUE;
		while((sum+sum)<=lDividend){
			sum+=sum;
			divide+=divide;
		}
		return sign* (divide+divideLong(lDividend-sum,lDivisor));
	}

}
