package xinghuangxu.leetcode;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
		int[] num={4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		LongestConsecutiveSequence lcs=new LongestConsecutiveSequence();
		System.out.println(lcs.longestConsecutive(num));
	}
	
	private HashMap<Integer,Integer> map= new HashMap<Integer, Integer>();
	
	public int longestConsecutive(int[] num) {
		int left,right,sum,res=0;
        for(int n:num){
        	if(!map.containsKey(n)){
        		left=map.containsKey(n-1)?map.get(n-1):0;
        		right=map.containsKey(n+1)?map.get(n+1):0;
        		
        		sum=left+right+1;
        		
        		if(sum>res){
        			res=sum;
        		}
        		map.put(n-left, sum);
        		map.put(n+right, sum);
        		map.put(n, sum);
        	}
        }
        return res;
    }
}
