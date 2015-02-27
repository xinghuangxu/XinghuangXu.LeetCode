package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber lcap = new LetterCombinationsOfAPhoneNumber();
		lcap.letterCombinations("23");
	}

	public List<String> letterCombinations(String digits) {
		List<String> rel = new ArrayList<String>();
		if(digits.length()==0)return rel;
		HashMap<Integer, String> phone = new HashMap<Integer, String>();
		phone.put(2, "abc");
		phone.put(3, "def");
		phone.put(4, "ghi");
		phone.put(5, "jkl");
		phone.put(6, "mno");
		phone.put(7, "pqrs");
		phone.put(8, "tuv");
		phone.put(9, "wxyz");
		getLetterCombinations(0, digits, "", phone, rel);
		return rel;
	}

	private void getLetterCombinations(int index, String digits, String string,
			HashMap<Integer, String> phone, List<String> rel) {
		if (index == digits.length()) {
			rel.add(string);
		} else {
			String val = phone.get(digits.charAt(index) - '0');
			for (int i = 0; i < val.length(); i++) {
				getLetterCombinations(index + 1, digits,
						string + val.charAt(i), phone, rel);
			}
		}
	}

}
