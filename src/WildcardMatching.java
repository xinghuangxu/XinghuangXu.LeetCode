import java.util.ArrayList;
import java.util.List;

public class WildcardMatching {

	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();

//		System.out.println(wm.isMatch("hi", "*?") == true);
//		System.out
//				.println(wm.isMatch("abefcdgiescdfimde", "ab*cd?i*de") == true);
//		System.out.println(wm.isMatch("aa", "aa") == true);
//		System.out.println(wm.isMatch("aa", "a?") == true);
//		System.out.println(wm.isMatch("", "*") == true);
//		System.out.println(wm.isMatch("abc", "*?*?*?*?") == false);
//		System.out.println(wm.isMatch("abc", "abc*defghijk") == false);
//		System.out.println(wm.isMatch("aa", "*") == true);
//		System.out.println(wm.isMatch("a", "aa") == false);
//		System.out.println(wm.isMatch("ab", "*a") == false);
		System.out.println(wm.isMatch("abcdefde", "abc*def") == false);
		System.out.println(wm.isMatch("abcdefghij", "abc*defghijk") == false);
		System.out.println(wm.isMatch("ab", "a*") == true);
		
		System.out.println(wm.isMatch("mississippi", "m*si*") == true);

	}

	/*
	 * only need to complete one search first need to make sure that end with
	 * star is the starting condition
	 */
	public boolean isMatch(String s, String p) {
		if (s.length() == 0 && p.length() == 0)
			return true;
		if (p.length() == 0)
			return false;
		if (s.length() == 0){
			for(int i=0;i<p.length();i++){
				if(p.charAt(i)!='*'){
					return false;
				}
			}
			return true;
		}
		String[] splits = p.split("\\*+");
		if (p.indexOf('*') !=-1) {
			boolean beginWithStar = false, endWithStar = false;
			if (p.charAt(0) == '*') { // begin with star
				beginWithStar = true;
			}
			if (p.charAt(p.length()-1) == '*') { // begin with star
				endWithStar = true;
			}
			List<String> words = new ArrayList<String>();
			for (String word : splits) {
				if (!word.equals("")) {
					words.add(word);
				}
			}
			return findWithSplits(words, s, beginWithStar, endWithStar);
		}
		return (findStringInAnother(s, p, false) == 0&&findStringInAnother(p, s, false) == 0);
	}

	private boolean findWithSplits(List<String> words, String s,
			boolean beginWithStar, boolean endWithStar) {
		if (words.size() == 0) {
			if (s.length() == 0 || endWithStar) {
				return true;
			} else {
				return false;
			}
		}
		if (s.length() == 0) {
			return false;
		}
		String temp = words.remove(0);
		if (words.size() == 0 && !endWithStar) {
			return findStringInAnother(temp, s, true) != -1;
		}
		int index = findStringInAnother(temp, s, false);
		if (index != -1) {
			if (!beginWithStar && index != 0)
				return false;
			return findWithSplits(words, s.substring(index + temp.length()),
					true, endWithStar);
		} else {
			return false;
		}
	}

	private int findStringInAnother(String temp, String s, boolean reverse) {
		if(temp.length()>s.length())return -1;
		int count = 0;
		for (int i = reverse ? s.length() - temp.length() : 0; i < s.length(); i++) {
			count=0;
			for(int j=i;j<i+temp.length()&&j<s.length();j++){
				if (temp.charAt(count) == '?' || temp.charAt(count) == s.charAt(j)
						|| s.charAt(j) == '?') {
					count++;
					if (count == temp.length()) {
						return i;
					}
				} else {
					break;
				}
			}
		}
		return -1;
	}
}
