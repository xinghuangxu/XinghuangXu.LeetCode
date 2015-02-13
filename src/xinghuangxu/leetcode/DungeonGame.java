package xinghuangxu.leetcode;

public class DungeonGame {
	

	public int calculateMinimumHP(int[][] dungeon) {
		int M=dungeon.length;
		int N=dungeon[0].length;
		int[] r1=new int[M];
		int[] r2=new int[M];
		for(int i=0;i<M;i++){
			r1[i]=Integer.MAX_VALUE;
		}
		r1[M-1]=0;
		int right,down;
		for(int i=N-1;i>-1;i--){
			for(int j=M-1;j>=0;j--){
				if(j==M-1){
					down=Integer.MAX_VALUE;
				}else{
					down=r2[j+1];
				}
				right=r1[j];
				r2[j]=Math.min(right, down)-dungeon[j][i];
				if(r2[j]<0){
					r2[j]=0;
				}
			}
			int[] temp=r1;
			r1=r2;
			r2=temp;
		}
		return r1[0]+1;
	}

//	private int getMinimumHP(int x, int y, int[][] dungeon) {
//		if(dungeon.length<=x||dungeon[x].length<=y){
//			return Integer.MIN_VALUE;
//		}
//		int cost=dungeon[x][y];
//		if(x+1==M&&y+1==N){
//			return cost;
//		}
//		int downMin=getMinimumHP(x+1, y, dungeon);
//		int rightMin=getMinimumHP(x, y+1, dungeon);
//		return cost+Math.max(rightMin, downMin);
//	}

	public static void main(String[] args) {
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		DungeonGame dg=new DungeonGame();
		System.out.println(dg.calculateMinimumHP(dungeon));
	}

}
