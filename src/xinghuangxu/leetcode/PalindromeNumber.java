package xinghuangxu.leetcode;

public class PalindromeNumber {

	public static void main(String[] args) {
		PalindromeNumber pn=new PalindromeNumber();
		System.out.println(pn.isPalindrome(-2147447412));
	}

	public boolean isPalindrome(int x) {
		long temp=x;
		if(temp<0)return false;
		temp=Math.abs(temp);
		long divisor=1; //divisor should start with 1 not 10!! because for x<10 will always get false since x/10=0 not itself
		while(temp/divisor>9){
			divisor*=10;
		}
		while(divisor!=1&&divisor!=0){
			if(temp%10!=temp/divisor){
				return false;
			}
			temp=temp%divisor;
			temp=temp/10;
			divisor=divisor/100;
		}
		return true;
	}

}
