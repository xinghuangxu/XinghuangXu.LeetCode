package xinghuangxu.leetcode;

import java.util.HashMap;

public class RomanToInteger {

	public static void main(String[] args) {
		RomanToInteger rti=new RomanToInteger();
		System.out.println(rti.romanToInt("MMMCMXCIX"));
	}

	public int romanToInt(String s) {
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
		int sum=0;
		for(int i=0;i<s.length();i++){
			if(i+1>=s.length()||map.get(s.charAt(i))>=map.get(s.charAt(i+1))){
				sum+=map.get(s.charAt(i));
			}else{
				sum-=map.get(s.charAt(i));
			}
		}
		return sum;
	}

}
