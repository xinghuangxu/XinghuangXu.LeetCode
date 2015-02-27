package xinghuangxu.leetcode;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums={1,2};
		RotateArray ra=new RotateArray();
		ra.rotate(nums, 3);
		for(int i:nums){
			System.out.println(i);
		}
	}

	public void rotate(int[] nums, int k) {
		int N=nums.length;
		int[] temp=new int[N];
		k=N-k%N;
		for(int i=k;i<N+k;i++){
			temp[i-k]=nums[i%N];
		}
		for(int i=0;i<N;i++){
			nums[i]=temp[i];
		}
	}

}
