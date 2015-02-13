package xinghuangxu.leetcode;

import java.util.HashMap;

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		FractionToRecurringDecimal ftrd = new FractionToRecurringDecimal();
		System.out.println(ftrd.fractionToDecimal(-1, -2147483648));
	}
	public String fractionToDecimal(int numerator, int denominator) {
		//get integer part
		String sign= ((numerator>0)^(denominator>0)&&numerator!=0)?"-":"";
		long den=Math.abs((long)denominator);
		long num=Math.abs((long)numerator);
		String left=(num/den)+"";
		long remainder=num%den;
		
		// remainder/denominator = 0.abcdefg
		// remainder*10/denominator = a.bcdefg
		StringBuilder right=new StringBuilder();
		long nextDigit;
		int i=0;
		HashMap<Long,Integer> map=new HashMap<Long, Integer>();
		map.put(remainder, right.length());
		while(remainder!=0&&i<100){
			//get the next number
			remainder*=10;
			nextDigit=remainder/den;
			right.append(nextDigit);
			//get the remainder after
			remainder=remainder%den;
			if(map.containsKey(remainder)){
				right.insert(map.get(remainder), "(");
				right.append(")");
				break;
			}else{
				map.put(remainder, right.length());
			}
		}
		return sign+left+(right.length()==0? "":"."+right.toString());
	}

}
