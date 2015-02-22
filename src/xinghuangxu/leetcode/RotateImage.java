package xinghuangxu.leetcode;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix ={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		RotateImage ri=new RotateImage();
		ri.rotate(matrix);
		System.out.println();
	}
	
	/*
	 * in place solution
	 */
	
	public void rotate(int[][] matrix) {
		int size = matrix.length;
		int rotate=0,val,temp;
		int x,y;
		for(int i=0;i<size/2;i++){
			for(int j=i;j<size-i-1;j++){
				rotate=0;
				val=matrix[i][j];
				y=i;x=j;
				while(rotate!=4){
					temp=x;
					x=y;
					y=temp;
					x=size-x-1; //moving right
					temp=matrix[y][x];
					matrix[y][x]=val;
					val=temp;
					rotate++;
				}
			}
		}

		
	}
	
	/*
	 * extra space solution
	 */
	public void rotate1(int[][] matrix) {
		int size = matrix.length;
		int[][] newMatrix=new int[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				newMatrix[j][size-i-1]=matrix[i][j];
			}
		}
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				matrix[i][j]=newMatrix[i][j];
			}
		}
		
	}

}
