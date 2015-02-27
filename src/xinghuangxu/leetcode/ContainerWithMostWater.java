package xinghuangxu.leetcode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		ContainerWithMostWater cww=new ContainerWithMostWater();
		int[] height={1,1};
		System.out.println(cww.maxArea(height));
	}
	
	public int maxArea(int[] height) {
		int max=0;
		int start=0,end=height.length-1;
		while(start<end){
			int size=(end-start)*Math.min(height[start], height[end]);
			if(size>max)max=size;
			if(height[start]>height[end]){
				end--;
			}else{
				start++;
			}
		}
		return max;
	}

	public int maxArea1(int[] height) {
		int L=2;
		int max=0;
		while(L<=height.length){
			for(int i=0;i<=height.length-L;i++){
				int j=i+L-1;
				int h=Math.min(height[i], height[j]);
				int area=h*L;
				if(area>max){
					max=area;
				}
			}
			L++;
		}
		return max;
	}

}
