package xinghuangxu.leetcode;

public class JumpGame {

	public static void main(String[] args) {
		JumpGame jg=new JumpGame();
		int[] A={2,3,1,1,4};
		System.out.println(jg.canJump(A));

	}

	public boolean canJump(int[] A) {
		boolean[] possible=new boolean[A.length];
		possible[A.length-1]=true;
		for(int i=A.length-2;i>-1;i--){
			int jump=A[i];
			for(int j=1;j<=jump;j++){
				if(i+j<=A.length-1&&possible[i+j]){
					possible[i]=true;
					break;
				}
			}
		}
		return possible[0];
	}

}
