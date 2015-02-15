package xinghuangxu.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
//		List<List<String>> rel = pp.partition("amanaplanacanalpanama");
		System.out.println(pp.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

	}
	
	public int minCut(String s) {
		Integer N=s.length();
		
		boolean[][] p=new boolean[N][N];
		int[] cut=new int[N];
		
		for(int i=0;i<N;i++){
			p[i][i]=true;
		}
		
		int j;
		for(int L=2;L<=N;L++){
			for(int i=0;i<N-L+1;i++){
				j=i+L-1;
				
				if(L==2){
					p[i][j]=s.charAt(i)==s.charAt(j);
				}else{
					p[i][j]=s.charAt(i)==s.charAt(j)&&p[i+1][j-1];
				}
				
				
				
			}
		}
		
		for(int i=0;i<N;i++){
			if(p[0][i]){
				cut[i]=0;
			}else{
				cut[i]=Integer.MAX_VALUE;
				for( j=0;j<i;j++){
					if(p[j+1][i]){
						cut[i]=Math.min(cut[i], cut[j]+1);
					}
				}
			}
		}
		
		return cut[N-1];
	}

	
	public int minCut1(String s) {
		Integer N=s.length();

		boolean[][] p=new boolean[N][N];
		int[][] cut=new int[N][N];
		
		for(int i=0;i<N;i++){
			p[i][i]=true;
			cut[i][i]=0;
		}
		
		int j;
		for(int L=2;L<=N;L++){
			for(int i=0;i<N-L+1;i++){
				j=i+L-1;
				
				if(L==2){
					p[i][j]=s.charAt(i)==s.charAt(j);
				}else{
					p[i][j]=s.charAt(i)==s.charAt(j)&&p[i+1][j-1];
				}
				
				if(p[i][j]){
					cut[i][j]=0;
				}else{
					cut[i][j]=Integer.MAX_VALUE;
					for(int k=i;k<j;k++){
						cut[i][j]=Math.min(cut[i][j], cut[i][k]+cut[k+1][j]+1);
					}
				}
				
			}
		}
		return cut[0][N-1];
	}


}
