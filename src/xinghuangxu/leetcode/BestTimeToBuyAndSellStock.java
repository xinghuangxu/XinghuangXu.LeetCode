package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock bbss=new BestTimeToBuyAndSellStock();
		int[] prices={1,2,4,2,5,7,2,4,9,0};
		System.out.println(bbss.maxProfitTwoTran(prices));
	}
	
	public int maxProfitTwoTran(int[] prices){
		List<Integer> profits=new ArrayList<Integer>();
		if(prices==null||prices.length<2)return 0;
		Integer bottom=null;
		if(prices[0]<prices[1]){
			bottom=prices[0];
		}
		for(int i=1;i<prices.length-1;i++){
			if(prices[i]>=prices[i-1]&&prices[i+1]<prices[i]){
				if(bottom!=null){
					profits.add(prices[i]-bottom);
					bottom=null;
				}
			}
			if(prices[i]<=prices[i-1]&&prices[i+1]>prices[i]){
				if(bottom==null){
					bottom=prices[i];
				}
			}
		}
		if(bottom!=null){ //if there is a bottom that has no peak match, the last one has to be a match
			profits.add(prices[prices.length-1]-bottom);
		}
		int first=0,second=0;
		for(int p:profits){
			if(p>=first){
				second=first;
				first=p;
			}
			if(p<first&&p>second){
				second=p;
			}
		}
		return first+second;
	}
	
	public int maxProfitMultiTran(int[] prices){
		if(prices==null||prices.length<2)return 0;
		Integer bottom=null,profit=0;
		if(prices[0]<prices[1]){
			bottom=prices[0];
		}
		for(int i=1;i<prices.length-1;i++){
			if(prices[i]>=prices[i-1]&&prices[i+1]<prices[i]){
				if(bottom!=null){
					profit += prices[i]-bottom;
					bottom=null;
				}
			}
			if(prices[i]<=prices[i-1]&&prices[i+1]>prices[i]){
				if(bottom==null){
					bottom=prices[i];
				}
			}
		}
		if(bottom!=null){ //if there is a bottom that has no peak match, the last one has to be a match
			profit+=prices[prices.length-1]-bottom;
		}
		return profit;
		
	}
	
	public int maxProfit(int[] prices) {
		if(prices==null||prices.length==0)return 0;
		int N=prices.length;
		int[] gain=new int[N];
		for(int i=1;i<N;i++){
			gain[i]=prices[i]-prices[i-1];
		}
		return getMaxProfit(0,N-1,gain);
	}
	private int getMaxProfit(int i, int j, int[] gain) {
		if(i==j)return gain[i];
		int mid=(i+j)/2;
		int leftMax=getMaxProfit(i,mid,gain);
		int rightMax=getMaxProfit(mid+1,j,gain);
		int crossMax=getCrossMax(mid,i,j,gain);
		return Math.max(Math.max(leftMax,rightMax), crossMax);
	}

	private int getCrossMax(int mid, int i, int j, int[] gain) {
		int leftMax=gain[mid];
		int leftSum=gain[mid];
		int left=mid-1;
		while(left>=i){
			leftSum+=gain[left];
			if(leftMax<leftSum){
				leftMax=leftSum;
			}
			left--;
		}
		
		int rightMax=gain[mid+1];
		int rightSum=gain[mid+1];
		int right=mid+2;
		while(right<=j){
			rightSum+=gain[right];
			if(rightMax<rightSum){
				rightMax=rightSum;
			}
			right++;
		}
		return leftMax+rightMax;
	}

}
