package xinghuangxu.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		MinStack ms=new MinStack();
		int[] num={5,98,45,23,1};
		for(int n :num){
			ms.push(n);
			System.out.println(ms.getMin());
		}

	}
	
	private Stack<Integer> stack=new Stack<Integer>();
	private Stack<Integer> minStack=new Stack<Integer>();

	public void push(int x) {
		if(stack.isEmpty()){
			stack.push(x);
			minStack.push(x);
		}else{
			stack.push(x);
			int y=minStack.peek();
			if(x<y){
				minStack.push(x);
			}else{
				minStack.push(y);
			}
		}
		
		
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}
