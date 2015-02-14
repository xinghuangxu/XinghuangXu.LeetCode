package xinghuangxu.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		EvaluateReversePolishNotation cvn = new EvaluateReversePolishNotation();
		
		System.out.println(cvn.evalRPN(new String[]{"3","-4","+"}));
	}
	
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<Integer>();
		int left,right;
		for(int i=0;i<tokens.length;i++){
			if(checkOperator(tokens[i])){
				right=stack.pop();
				left=stack.pop();
				stack.push(operation(left,right,tokens[i]));
			}else{
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}
	
	public boolean checkOperator(String st){
		return st.equals("+") || st.equals("-") || st.equals("*")|| st.equals("/");
	}
	
	public int operation(int i, int j, String op) {
	    switch (op) {
	    case "+": return i+j;
	    case "-": return i-j;
	    case "*": return i*j;
	    default: return i/j;
	    }
	}
}
