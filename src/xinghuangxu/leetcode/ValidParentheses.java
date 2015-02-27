package xinghuangxu.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//()[]{}
		ValidParentheses vp=new ValidParentheses();
		System.out.println(vp.isValid("()[{}"));
	}

	public boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ' ');
		map.put('{', ' ');
		map.put('[', ' ');
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == ' ') {
				stack.push(s.charAt(i));
			} else if (stack.isEmpty()) {
				return false;
			} else if (map.get(s.charAt(i)) == stack.peek()) {
				stack.pop();
			} else {
				return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

}
