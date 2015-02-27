package xinghuangxu.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger ri=new ReverseInteger();
		System.out.println(ri.reverse(1463847412));
	}

	public int reverse(int x) {
		int temp=x,rel=0,power=10;
		while(temp!=0){  //Need to consider OVERFLOW!!!!
			if(rel>0&&(rel>Integer.MAX_VALUE/10||(rel==Integer.MAX_VALUE&&temp%power>=7))){
				return 0;
			}
			if(rel<0&&(rel<Integer.MIN_VALUE/10||(rel==Integer.MIN_VALUE&&temp%power<=-8))){
				return 0;
			}
			rel=rel*power+temp%power;
			temp=temp/power;
		}
		return rel;
	}

}
