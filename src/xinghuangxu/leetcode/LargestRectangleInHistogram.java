package xinghuangxu.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();
		int[] height = { 2, 1, 5, 6, 2, 3 };
		System.out.println(lrh.largestRectangleArea(height));
	}
	
	/*
	 * Precise O(n) solution
	 */
	public int largestRectangleArea(int[] height) {
		int N = height.length, max=0,top=0;
		Stack<Integer> stack = new Stack<Integer>();
		int[] h=Arrays.copyOf(height, height.length+1);
		for (int i = 0; i <= N;) {
			if (stack.isEmpty() || h[i] > h[stack.peek()]) {
				stack.push(i++);
			} else {
				top = stack.pop();
				max = Math.max(max,
						h[top] * (stack.isEmpty()?i:i - stack.peek()-1));
			}
		}
		return max;
	}
	
	/*
	 * O(n) solution
	 
	public int largestRectangleArea(int[] height) {
		int N = height.length, temp, rel = 0, max = 0, currentMin;
	Stack<Integer> stack = new Stack<Integer>();
	stack.push(0);
	for (int i = 1; i <= N; i++) {
		if (stack.peek()==0||height[i - 1] > height[stack.peek() - 1]) {
			stack.push(i);
		} else {
			rel = 0;
			currentMin = height[stack.peek() - 1];
			while (stack.peek()!=0&&height[stack.peek() - 1] > height[i - 1]) {
				temp = stack.pop();
				if (height[temp - 1] < currentMin) {
					currentMin = height[temp - 1];
				}
				rel = currentMin * (i - stack.peek()-1);
				if (rel > max)
					max = rel;
			}
			stack.push(i);
		}
	}
	while (!stack.isEmpty()&&stack.peek()!=0) {
		rel = 0;
		currentMin = height[stack.peek() - 1];
		temp = stack.pop();
		if (height[temp - 1] < currentMin) {
			currentMin = height[temp - 1];
		}
		rel = currentMin * (N - stack.peek());
		if (rel > max)
			max = rel;

	}
	return max;
}
	*/

	/*
	 * Devide and Conquer Solution - O(nlg(n))
	 * 
	 * public int largestRectangleArea(int[] height) { if (height ==
	 * null||height.length==0) return 0; return findLargestRectangleArea(0,
	 * height.length-1, height); }
	 * 
	 * private int findLargestRectangleArea(int lo, int hi, int[] height) { if
	 * (lo == hi) return height[lo]; // divide and conquer int mid = (lo + hi) /
	 * 2, leftMax = 0, rightMax = 0; leftMax = findLargestRectangleArea(lo, mid,
	 * height); rightMax = findLargestRectangleArea(mid + 1, hi, height); int i
	 * = mid - 1, j = mid + 1, size = height[mid], width = 1, temp, currentMax =
	 * height[mid]; while (i >= lo && j <= hi) { width++; if (height[i] >
	 * height[j]) { if (height[i] < currentMax) { currentMax = height[i]; } i--;
	 * } else { if (height[j] < currentMax) { currentMax = height[j]; } j++; }
	 * temp = currentMax * width; if(temp>size)size=temp; } while (i >= lo) {
	 * width++; if (height[i] < currentMax) { currentMax = height[i]; } temp =
	 * currentMax * width; if(temp>size)size=temp; i--; } while (j <= hi) {
	 * width++; if (height[j] < currentMax) { currentMax = height[j]; } temp =
	 * currentMax * width; if(temp>size)size=temp; j++; } return
	 * Math.max(Math.max(leftMax,rightMax), size); }
	 */
	/*
	 * O(N^2) solution
	 * 
	 * public int largestRectangleArea(int[] height) { int
	 * N=height.length,max=0,temp; for(int i=0;i<N;i++){
	 * temp=maxRectangle(i,height); max= temp > max?temp:max; } return max; }
	 * 
	 * private int maxRectangle(int i, int[] height) { int
	 * size=height[i],currentHeight=height[i],width=1,temp=0; for(int
	 * j=i+1;j<height.length;j++){ if(height[j]<currentHeight){
	 * currentHeight=height[j]; } width++; temp=currentHeight*width;
	 * size=temp>size?temp:size; } return size; }
	 */

}
