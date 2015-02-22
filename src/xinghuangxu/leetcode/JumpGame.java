package xinghuangxu.leetcode;

public class JumpGame {

	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] A = { 2,0,2,0,1 };
		// System.out.println(jg.canJump(A));
		System.out.println(jg.jump(A));
	}

	public boolean canJump(int[] A) {
		boolean[] possible = new boolean[A.length];
		possible[A.length - 1] = true;
		int last = A.length - 1;
		for (int i = A.length - 2; i > -1; i--) {
			int jump = A[i];
			if (i + jump >= last) {
				possible[i] = true;
				last = i;
			}
		}
		return possible[0];
	}

	/*
	 * A event faster approach Some optimization
	 */
	public int jump(int[] A) {
		// int[] possible=new int[A.length];
		int N = A.length;
		int[] l1 = new int[A.length];
		int[] l2 = new int[A.length];
		int[] temp;

		for (int j = 0; j < N; j++) {
			l1[j] = j==N-1?0:Integer.MAX_VALUE-100;
			l2[j] = j==N-1?0:Integer.MAX_VALUE-100;
		}
		for (int i = N - 2; i > -1; i--) {
			int jump = A[i];
			if (i + jump >= N)
				jump = N - i - 1;
			l1[i] = 1 + l2[i + jump];
			if(i==0)break;
			if(l1[i]>=l2[i+1]){
				//no need to switch list
				l2[i]=l1[i];
			}else{
				//update l1
				for (int j = i + 1; j < N; j++) {
					l1[j] = Math.min(l1[i],
							l2[j]);
				}
				//switch list
				temp=l1;
				l1=l2;
				l2=temp;
			}
		}
		return l1[0];
	}

	/*
	 * Simple O(n^2) solution
	 */
	public int jump1(int[] A) {
		// int[] possible=new int[A.length];
		int N = A.length, Size = 2;
		int[][] minimum = new int[Size][A.length];
		for (int i = 0; i < Size; i++) {
			for (int j = 0; j < N; j++) {
				minimum[i][j] = Integer.MAX_VALUE;
			}
		}
		minimum[0][N - 1] = 0;
		minimum[1][N - 1] = 0;
		for (int i = N - 2; i > -1; i--) {
			int jump = A[i];
			if (i + jump >= N)
				jump = N - i - 1;
			minimum[i % 2][i] = 1 + minimum[(i + 1) % 2][i + jump];
			if (i == 0)
				break;
			for (int j = i + 1; j < N; j++) {
				minimum[i % 2][j] = Math.min(minimum[i % 2][i],
						minimum[(i + 1) % 2][j]);
			}
		}
		return minimum[0][0];
	}

}
