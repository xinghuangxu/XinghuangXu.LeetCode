package xinghuangxu.leetcode;

public class NextPermutation {

	public static void main(String[] args) {
		int[][] test={
//				{1,2,3},
//				{3,2,1},
//				{1,1,5},
				{1,3,2},
//				{2,3,1},
//				{4,2,0,2,3,2,0}
		};
		NextPermutation np=new NextPermutation();
		for(int i=0;i<test.length;i++){
			np.nextPermutation(test[i]);
		}
		for(int i=0;i<test.length;i++){
			for(int j=0;j<test[i].length;j++){
				System.out.print(test[i][j]);
			}
			System.out.println();
		}
	}

	public void nextPermutation(int[] num) {
		int N=num.length,temp;
		for(int i=N-2;i>-1;i--){
			boolean found=false;
			Integer minIndex=null;
			for(int j=i+1;j<N;j++){
				if(num[i]<num[j]){
					if(minIndex==null||num[minIndex]>num[j]){
						found=true;
						minIndex=j;
					}
				}
			}
			if(found){
				temp=num[i];
				num[i]=num[minIndex];
				num[minIndex]=temp;
				sort(num,i+1,N-1);
				return;
			}
		}
		for(int i=0;i<N/2;i++){
			temp=num[i];
			num[i]=num[N-i-1];
			num[N-i-1]=temp;
		}
	}

	private void sort(int[] num, int lo, int hi) { //sort part of the array
		for(int i=lo+1;i<=hi;i++){
			int temp=num[i];
			int j=i-1;
			while(num[j]>temp&&j>=lo){
				num[j+1]=num[j];
				j--;
			}
			num[j+1]=temp;
		}
	}

}
