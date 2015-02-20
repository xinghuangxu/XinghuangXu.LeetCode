package xinghuangxu.leetcode;

public class PlusOne {

	public static void main(String[] args) {
		PlusOne po=new PlusOne();
		int[] digits={8,9,9,9};
		int[] rel=po.plusOne(digits);
		for(int i:rel){
			System.out.print(i);
		}
	}

	public int[] plusOne(int[] digits) {
		int[] newDigits=new int[digits.length];
		int i;
		//increment the 1
		boolean increment=false;
		for( i=digits.length-1;i>-1;i--){
			if(digits[i]<9){
				newDigits[i]=digits[i]+1;
				increment=true;
				break;
			}else{
				newDigits[i]=0;
			}
		}
		i--;
		if(!increment){
			newDigits=new int[digits.length+1];
			newDigits[0]=1;
		}else{
			while(i>-1){
				newDigits[i]=digits[i];
				i--;
			}
		}
		return newDigits;
	}

}
