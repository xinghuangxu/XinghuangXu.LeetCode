package xinghuangxu.leetcode;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		int[][] matrix={
				{1,1,1},
				{1,0,1},
				{1,1,1}
		};
		SetMatrixZeroes smz=new SetMatrixZeroes();
		smz.setZeroes(matrix);
		System.out.println();
	}

	public void setZeroes(int[][] matrix) {
		if(matrix==null||matrix.length==0)return;
		int last_row = -1,M=matrix.length,N=matrix[0].length;
		//find the first row with zero;
		for(int i=0;i<M&&last_row==-1;i++){
			for(int j=0;j<N;j++){
				if(matrix[i][j]==0){
					last_row=i;
					break;
				}
			}
		}
		if(last_row==-1)return;
		//scan the rest of the columns
		boolean found=false;
		for(int i=last_row+1;i<M;i++){
			found=false;
			for(int j=0;j<N;j++){
				if(matrix[i][j]==0){
					matrix[last_row][j]=0;
					found=true;
				}
			}
			if(found==true){
				for(int j=0;j<N;j++){
					matrix[i][j]=0;
				}
			}
		}
		//go back to the last row set column zeros based on that
		for(int j=0;j<N;j++){
			if(matrix[last_row][j]==0){
				for(int i=0;i<M;i++){
					matrix[i][j]=0;
				}
			}
		}
		//set the last row to zeros;
		for(int j=0;j<N;j++){
			matrix[last_row][j]=0;
		}
		
	}

}
