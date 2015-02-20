package xinghuangxu.leetcode;

public class EditDistance {

	public static void main(String[] args) {
		EditDistance ed=new EditDistance();
		System.out.println(ed.minDistance("trials", ""));
	}

	public int minDistance(String word1, String word2) {
		int m=word1.length(),n=word2.length();
		int[][] distance=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			distance[i][0]=i;
		}
		for(int i=0;i<=n;i++){
			distance[0][i]=i;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				distance[i][j]=Math.min(Math.min(distance[i-1][j]+1,distance[i][j-1]+1), 
						distance[i-1][j-1]+ (word1.charAt(i-1)==word2.charAt(j-1)?0:1));
			}
		}
		return distance[m][n];
	}

}
