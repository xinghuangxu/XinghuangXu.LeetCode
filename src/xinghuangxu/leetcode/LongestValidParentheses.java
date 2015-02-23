package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		LongestValidParentheses lvp=new LongestValidParentheses();
		String[] strs={
//				"(()",
				")()())"
		};
		for(String s:strs){
			System.out.println(lvp.longestValidParentheses(s));
		}
		
	}


	class Range {
		int x1, x2,val;

		Range(int x1, int x2) {
			this.x1 = x1;
			this.x2 = x2;
			this.val=x2-x1+1;
		}
	}

	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Range> range = new Stack<Range>();
		Integer temp;
		Range tRange, merges;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					temp = stack.pop();
					tRange = new Range(temp, i);
					merges=tRange;
					while (!range.isEmpty()) {
						merges = mergeRange(merges, range.peek());
						if(merges!=null){
							range.pop();
							tRange=merges;
						}else{
							break;
						}
					}
					range.add(tRange);
				}
			} else {
				stack.push(i);
			}
		}
		int max=0;
		while(!range.isEmpty()){
			tRange=range.pop();
			if(tRange.val>max){
				max=tRange.val;
			}
		}
		return max;
	}

	private Range mergeRange(Range newRange, Range oldRange) {
		if(oldRange==null)return null;
		if (newRange.x2 > oldRange.x2 && newRange.x1 < oldRange.x1) {
			return newRange;
		}
		if (newRange.x1 - 1 == oldRange.x2) {
			return new Range(oldRange.x1,newRange.x2);
		}
		return null;
	}

}
