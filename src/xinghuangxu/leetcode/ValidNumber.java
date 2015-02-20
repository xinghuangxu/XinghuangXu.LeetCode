package xinghuangxu.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber {

	public static void main(String[] args) {
		String[] sample={"0"," 0.1 ","abc","1 a","2e10",".1"," ","3.","+1.","46.e3",".2e81","2e0","e9"," 005047e+6"};
		ValidNumber vn=new ValidNumber();
		for(String s:sample){
			System.out.println(vn.isNumber(s));
		}
	}

	public boolean isNumber(String s) {
		String[] patternStrings = {"\\s*[+-]?((\\d+\\.?)|(\\.?\\d+))\\d*(e[+-]?\\d+)?\\s*"};
		Pattern pattern;
		Matcher matcher;
		for (String p : patternStrings) {
			pattern = Pattern.compile(p);
			matcher = pattern.matcher(s);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

}
