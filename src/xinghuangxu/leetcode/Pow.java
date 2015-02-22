package xinghuangxu.leetcode;

public class Pow {

	public static void main(String[] args) {
		Pow pow = new Pow();
		for(int i=0;i<10;i++){
			System.out.println(i+":"+pow.pow(1.00000, -2147483648));
		}
	}
	
	public double pow(double x, int n) {
		if(n==0)return 1;
		if(n==1)return x;
		if(n==Integer.MIN_VALUE)return x*1/pow(x,n+1);
		if(n<0)return 1/pow(x,-n);
		
		
		double halfpow=pow(x,n/2);
		return halfpow*halfpow*pow(x,n%2);
	}
	
	/*
	 * This is a terrible solution
	 */
	public double pow1(double x, int n) {
		double N=n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		if (N == 0)
			return 1;// everything to the zero power equal to zero;
		double i;
		double prev = 1, current=x;
		for (i = 2; i < N + 1; i = i * 2) {
			prev = current;
			current = prev * prev;
		}
		if (i >= N + 1) {
			if(i-N+1<N+1-i/2){
				prev = current;
				current = prev * prev;
				for (double j = i ; j >= N + 1; j--) {
					prev = current;
					current = prev/x;
				}
			}else{
				for (double j = i / 2 + 1; j < N + 1; j++) {
					prev = current;
					current = x * prev;
				}
			}
			
		}
		return current;
	}

}
