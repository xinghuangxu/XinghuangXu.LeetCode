package xinghuangxu.leetcode;

public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay cay=new CountAndSay();
		System.out.println(cay.countAndSay(5));
	}

	public String countAndSay(int n) {
		String[] result=new String[n];
		result[0]="1";
		for(int i=1;i<n;i++){
			result[i]=getSequence(result[i-1]);
		}
		return result[n-1];
	}
	
	public String getSequence(String word){
		StringBuilder sb=new StringBuilder();
		char c;
		for(int i=0;i<word.length();){
			int count=0;
			c=word.charAt(i);
			while(i<word.length()&&c==word.charAt(i)){
				count++;
				i++;
			}
			sb.append(count+""+c);
		}
		return sb.toString();
	}

}
