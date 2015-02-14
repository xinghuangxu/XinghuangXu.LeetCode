package xinghuangxu.leetcode;

public class ReverseWordsInAString {
	public static void main(String[] arg) {
		ReverseWordsInAString rwis = new ReverseWordsInAString();
		System.out.println(rwis.reverseWords("   a   b "));
	}

	public String reverseWords(String s) {
		String[] words=s.split("\\s+");
		StringBuilder sb=new StringBuilder();
		for(int i=words.length-1;i>-1;i--){
			if(words[i].trim()!=""){
				sb.append(words[i].trim());
				sb.append(" ");
			}
		}
		return sb.toString().trim();
	}
}
