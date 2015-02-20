package xinghuangxu.leetcode;

public class AddBinary {

	public static void main(String[] args) {
		AddBinary ab=new AddBinary();
		System.out.println(ab.addBinary("1", "0"));
	}

	public String addBinary(String a, String b) {
		int i=a.length()-1,j=b.length()-1;
		StringBuilder sb=new StringBuilder(0);
		boolean increment=false;
		while(i>-1&&j>-1){
			if(a.charAt(i)==b.charAt(j)){
				if(a.charAt(i)=='1'){ //two ones
					if(increment){
						sb.append('1');
					}else{
						sb.append('0');
						increment=true;
					}
				}else{ //two zeros
					if(increment){
						sb.append('1');
						increment=false;
					}else{ //do nothing
						sb.append('0');
					}
				}
			}else{ //one zero one one
				if(increment){
					sb.append('0');
				}else{
					sb.append('1');
				}
			}
			i--;
			j--;
		}
		while(i>-1){
			if(a.charAt(i)=='1'){
				if(increment){
					sb.append('0');
				}else{
					sb.append('1');
				}
			}else{
				if(increment){
					sb.append('1');
					increment=false;
				}else{
					sb.append('0');
				}
			}
			i--;
		}
		while(j>-1){
			if(b.charAt(j)=='1'){
				if(increment){
					sb.append('0');
				}else{
					sb.append('1');
				}
			}else{
				if(increment){
					sb.append('1');
					increment=false;
				}else{
					sb.append('0');
				}
			}
			j--;
		}
		if(increment){
			sb.append('1');
		}
		return sb.reverse().toString();
	}

}
