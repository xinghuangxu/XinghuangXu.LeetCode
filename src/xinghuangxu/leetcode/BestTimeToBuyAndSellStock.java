package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock bbss = new BestTimeToBuyAndSellStock();
		int[] prices = { 1, 2 ,4,5,3,5,12,0};
		System.out.println(bbss.maxProfitKTran(19,prices));
	}

	public int maxProfitKTran(int k, int[] prices) {
		if(k>prices.length/2)return maxUnlimitedTran(prices);
		int[][] f=new int[k+1][prices.length];
		for(int kk=1;kk<=k;kk++){
			int tempMax=f[kk-1][0]-prices[0];
			for(int i=1;i<prices.length;i++){
				f[kk][i]=Math.max(f[kk][i-1], prices[i]+tempMax);
				tempMax=Math.max(tempMax, f[kk-1][i]-prices[i]);
			}
		}
		return f[k][prices.length-1];
	}

	private int maxUnlimitedTran(int[] prices) {
		int max=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>=prices[i-1]){
				max+=prices[i]-prices[i-1];
			}
		}
		return max;
	}

	class Node {
		int peak;
		int bottom;
		int val;

		Node(int peak, int bottom) {
			this.peak = peak;
			this.bottom = bottom;
			this.val = peak - bottom;

		}
	}

	public int maxProfitMultiTran3(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		// get the max array
		int N = prices.length;
		int[] profits = new int[N];
		int low = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < profits.length; i++) {
			if (prices[i] < low) {
				low = prices[i];
			} else if (prices[i] - low > maxProfit) {
				maxProfit = prices[i] - low;
			}
			profits[i] = maxProfit;
		}
		// calculate the best time to sell stock and at the same time keep track
		// of the height
		int reverseMax = prices[N - 1];
		int result = 0;
		for (int i = N - 2; i >= 0; i--) {
			if (result < reverseMax - prices[i] + (i == 0 ? 0 : profits[i - 1])) {
				result = reverseMax - prices[i] + (i == 0 ? 0 : profits[i - 1]);
			}
			if (prices[i] > reverseMax)
				reverseMax = prices[i];
		}
		return result;
	}

	public int maxProfitTwoTran(int[] prices) {
		List<Node> profits = new ArrayList<Node>();
		if (prices == null || prices.length < 2)
			return 0;
		Integer bottom = null;
		if (prices[0] < prices[1]) {
			bottom = prices[0];
		}
		for (int i = 1; i < prices.length - 1; i++) {
			if (prices[i] >= prices[i - 1] && prices[i + 1] < prices[i]) {
				if (bottom != null) {
					profits.add(new Node(prices[i], bottom));
					bottom = null;
				}
			}
			if (prices[i] <= prices[i - 1] && prices[i + 1] > prices[i]) {
				if (bottom == null) {
					bottom = prices[i];
				}
			}
		}
		if (bottom != null) { // if there is a bottom that has no peak match,
								// the last one has to be a match
			profits.add(new Node(prices[prices.length - 1], bottom));
		}
		return findMaxTwoCombination(profits);
	}

	private int findMaxTwoCombination(List<Node> profits) {
		if (profits.size() == 0)
			return 0;
		int maxSum = profits.get(0).val, N = profits.size();
		Node[][] s = new Node[N][N];
		for (int i = 0; i < N; i++) {
			s[i][i] = profits.get(i);
		}
		Node prev, cur, newNode;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				prev = s[i][j - 1];
				cur = profits.get(j);
				newNode = new Node(cur.peak, prev.bottom);
				if (prev.val >= cur.val && prev.val >= newNode.val) {
					s[i][j] = prev;
				} else if (cur.val >= prev.val && cur.val >= newNode.val) {
					s[i][j] = cur;
				} else {
					s[i][j] = newNode;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (s[i][j] != null && s[i][j].val < 0) {
					System.out.println("No good");
				}
			}
		}
		// if(this.val<0){
		// System.out.println("No good");
		// }
		maxSum = s[0][N - 1].val;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N - 1; j++) {
				maxSum = Math.max(maxSum, s[i][j].val + s[j + 1][N - 1].val);
			}
		}
		return maxSum;
	}

	public int maxProfitMultiTran2(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int N = prices.length;
		int[] profits = new int[N];
		profits[0] = 0;
		for (int i = 1; i < N; i++) {
			profits[i] = prices[i] - prices[i - 1];
		}
		int profit = 0;
		for (int i = 1; i < N; i++) {
			if (profits[i] >= 0) {
				profit += profits[i];
			}
		}
		return profit;
	}

	public int maxProfitMultiTran(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		Integer bottom = null, profit = 0;
		if (prices[0] < prices[1]) {
			bottom = prices[0];
		}
		for (int i = 1; i < prices.length - 1; i++) {
			if (prices[i] >= prices[i - 1] && prices[i + 1] < prices[i]) {
				if (bottom != null) {
					profit += prices[i] - bottom;
					bottom = null;
				}
			}
			if (prices[i] <= prices[i - 1] && prices[i + 1] > prices[i]) {
				if (bottom == null) {
					bottom = prices[i];
				}
			}
		}
		if (bottom != null) { // if there is a bottom that has no peak match,
								// the last one has to be a match
			profit += prices[prices.length - 1] - bottom;
		}
		return profit;

	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int N = prices.length;
		int[] gain = new int[N];
		for (int i = 1; i < N; i++) {
			gain[i] = prices[i] - prices[i - 1];
		}
		return getMaxProfit(0, N - 1, gain);
	}

	private int getMaxProfit(int i, int j, int[] gain) {
		if (i == j)
			return gain[i];
		int mid = (i + j) / 2;
		int leftMax = getMaxProfit(i, mid, gain);
		int rightMax = getMaxProfit(mid + 1, j, gain);
		int crossMax = getCrossMax(mid, i, j, gain);
		return Math.max(Math.max(leftMax, rightMax), crossMax);
	}

	private int getCrossMax(int mid, int i, int j, int[] gain) {
		int leftMax = gain[mid];
		int leftSum = gain[mid];
		int left = mid - 1;
		while (left >= i) {
			leftSum += gain[left];
			if (leftMax < leftSum) {
				leftMax = leftSum;
			}
			left--;
		}

		int rightMax = gain[mid + 1];
		int rightSum = gain[mid + 1];
		int right = mid + 2;
		while (right <= j) {
			rightSum += gain[right];
			if (rightMax < rightSum) {
				rightMax = rightSum;
			}
			right++;
		}
		return leftMax + rightMax;
	}

}
