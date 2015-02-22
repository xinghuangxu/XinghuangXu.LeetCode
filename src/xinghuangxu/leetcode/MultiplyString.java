package xinghuangxu.leetcode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MultiplyString {

	public static void main(String[] args) {
		MultiplyString ms=new MultiplyString();
		System.out.println(ms.multiply("140", "721"));
	}
	
	 public String multiply(String num1, String num2) {
	        List<String> rels=new ArrayList<String>();
	        //multiply one number at a time
	        for(int i=0;i<num2.length();i++){
	        	String mul=multiplySingle(num1,num2.charAt(i),num2.length()-i-1);
	        	if(!mul.matches("0+")){
	        		rels.add(multiplySingle(num1,num2.charAt(i),num2.length()-i-1));
	        	}
	        }
	        if(rels.size()>0){
	        	String result=rels.get(0);
		        for(int i=1;i<rels.size();i++){
		        	result=StringIntegerAdd(result,rels.get(i));
		        }
		        return result;
	        }else{
	        	return "0";
	        }
	        
	 }

	private String StringIntegerAdd(String n1, String n2) {
		StringBuilder sb=new StringBuilder();
		int L1=n1.length(),L2=n2.length(),i=L1-1,j=L2-1,increment=0,temp,left;
		while(j>-1&&i>-1){
			temp=n1.charAt(i)-N+n2.charAt(j)-N+increment;
			left=temp%10;
			increment=temp/10;
			sb.insert(0, left);
			j--;
			i--;
		}
		while(j>-1){
			temp=n2.charAt(j)-N+increment;
			left=temp%10;
			increment=temp/10;
			sb.insert(0, left);
			j--;
		}while(i>-1){
			temp=n1.charAt(i)-N+increment;
			left=temp%10;
			increment=temp/10;
			sb.insert(0, left);
			i--;
		}
		if(increment!=0){
			sb.insert(0, increment);
		}
		return sb.toString();
	}
	int N=48;
	private String multiplySingle(String num1, char digit, int padding) {
		if(digit==48)return "0";
		StringBuilder sb=new StringBuilder();
		int increment=0,temp,d=digit-N,left;
		for(int i=num1.length()-1;i>-1;i--){
			temp=(num1.charAt(i)-N)*d;
			left=temp%10+increment;
			if(left>9){
				temp+=10;
				left=left%10;
			}
			increment=temp/10;
			sb.insert(0,left);
		}
		if(increment!=0){
			sb.insert(0,increment);
		}
		while(padding!=0){
			sb.append("0");
			padding--;
		}
		return sb.toString();
	}

}
