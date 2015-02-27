package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		GenerateParentheses gp=new GenerateParentheses();
		List<String> rel=gp.generateParenthesis(3);
		for(String s:rel){
			System.out.println(s);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> rel = new ArrayList<String>();
		generate(n, n, 0, "", rel);
		return rel;
	}

	private void generate(int openLeft, int closeLeft, int unclosed,
			String pre, List<String> rel) {
		if (openLeft == 0 && closeLeft == 0) {
			rel.add(pre);
		} else {
			if (openLeft != 0) {
				generate(openLeft - 1, closeLeft, unclosed + 1, pre + "(", rel);
			}
			if(closeLeft!=0&&unclosed!=0){
				generate(openLeft,closeLeft-1,unclosed-1,pre+")",rel);
			}
		}
	}

}
