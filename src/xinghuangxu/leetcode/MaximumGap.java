package xinghuangxu.leetcode;

import java.util.Arrays;
import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

public class MaximumGap {

	public static void main(String[] arg) {
		MaximumGap mg = new MaximumGap();
		int[] num = { 1,10000000 };
		System.out.println(mg.maximumGap(num));
	}
	
	class Pair{
		public int min;
		public int max;
		public Pair(int min,int max){
			this.min=min;
			this.max=max;
		}
		
	}
	
	public int maximumGap(int[] num) {
		if(num.length<2)return 0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		int N=num.length;
		for(int i=0;i<N;i++){
			if(num[i]>max){
				max=num[i];
			}
			if(num[i]<min){
				min=num[i];
			}
		}
		int dist=(max-min-1)/(N-1)+1;
		Pair[] buckets=new Pair[N];
		int bucketIndex;
		for(int i=0;i<N;i++){
			bucketIndex=(num[i]-min)/dist;
			Pair p=buckets[bucketIndex];
			if(p==null){
				buckets[bucketIndex]=new Pair(num[i],num[i]);
			}else{
				p.min=Math.min(p.min,num[i]);
				p.max=Math.max(p.max, num[i]);
			}
		}
		int maxGap=dist;
		int prevMax=buckets[0].max;
		for(int i=1;i<N;i++){
			if(buckets[i]!=null){
				maxGap=Math.max(maxGap, buckets[i].min-prevMax);
				prevMax=buckets[i].max;
			}
		}
		return maxGap;
	}
	
	/*
	 * This solution takes time nlgn
	 */
	public int maximumGap3(int[] num) {
		Arrays.sort(num);
		int max=0,dif;
		for(int i=1;i<num.length;i++){
			dif=num[i]-num[i-1];
			if(dif>max){
				max=dif;
			}
		}
		return max;
	}

	
	/*
	 * The belowing algorihtm runs in O(n^2)
	 */
	public int maximumGap2(int[] num) {
		int max = Integer.MIN_VALUE;
		int[] gap = new int[num.length];
		for(int i=0;i<num.length;i++){
			gap[i]=Integer.MAX_VALUE;
		}
		int dif = 0;
		boolean min=false;
		for (int i = 0; i < num.length; i++) {
			min=true;
			for (int j = 0; j < num.length; j++) {
				if(i!=j){
					dif = Math.abs(num[i] - num[j]);
					if(dif<gap[i]&&num[i]>num[j]){
						gap[i]=dif;
						min=false;
					}
				}
			}
			if(min){
				gap[i]=0;
			}
		}
		for(int i=0;i<num.length;i++){
			if(max<gap[i]){
				max=gap[i];
			}
		}
		return max;
	}
}
