/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5,31, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
package xinghuangxu.leetcode;

public class LargestNumber {

	public String largestNumber(int[] num) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<num.length-1;i++){
			for(int j=i+1;j<num.length;j++){
				if(this.compare(num[i],num[j])){
					this.swap(num,i,j);
				}
			}
		}
		for(int i=0;i<num.length;i++){
			sb.append(num[i]);
		}
		if(sb.charAt(0)=='0'){
			return "0";
		}
		return sb.toString();
	}

	private void swap(int[] num, int i, int j) {
		int temp=num[i];
		num[i]=num[j];
		num[j]=temp;
	}

	private boolean compare(int a, int b) {
		String ab=a+""+b;
		String ba=b+""+a;
		return Double.parseDouble(ab)<Double.parseDouble(ba);
//		int dif=Math.abs((a+"").length()-(b+"").length());
//		if(a>b){
//			b=this.pad(b,dif);
//			if(a==b){
//				return true;
//			}
//		}else{
//			a=this.pad(a,dif);
//			if(a==b){
//				return false;
//			}
//		}
//		return a<b;
	}

	private int pad(int b, int dif) {
		char pad=(b+"").charAt(0);
		String result="";
		while(dif>0){
			result+=pad;
			dif--;
		}
		return Integer.parseInt(b+result);
	}

	public static void main(String[] args) {
		LargestNumber ln=new LargestNumber();
		int[] num={999999998,999999997,999999999};
		System.out.println(ln.largestNumber(num));
		// TODO Auto-generated method stub

	}

}
