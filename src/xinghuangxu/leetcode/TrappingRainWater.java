package xinghuangxu.leetcode;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] A={4,3,8,3,1,5,9,9,0,4,3,4,7};//{0,1,0,2,1,0,1,3,2,1,2,1};//{5,2,1,2,1,5};//{0,1,0,2,1,0,1,3,2,1,2,1};
		TrappingRainWater trw=new TrappingRainWater();
		System.out.println(trw.trap(A));
	}

	public int trap(int[] A) {
		find(A,0,A.length-1);
		return sum;
	}
	int sum=0;
	public void find(int[] A,int a,int b){
		Integer bottom=null,top1=null,top2=null,height;
		for(int i=a;i<b;i++){
			if(A[i]<A[i+1]){
				if(bottom==null&&top1!=null){
					bottom=i;
				}
			}else if(A[i+1]<A[i]){
				if(top1!=null&&bottom!=null){
					if(A[top1]<=A[i]){
						top2=i;
						height=Math.min(A[top1], A[top2]);
						for(int j=top1+1;j<top2;j++){
							sum+=(height-A[j])>0?height-A[j]:0;
						}
						bottom=null;
						top1=top2;
						top2=null;
					}else{
						if(top2==null||A[top2]<=A[i]){
							top2=i;
						}
					}
				}
				if(top1==null)
					top1=i;
			}
		}
		if(bottom!=null&&top1!=null){
			if(A[b]>=A[top1]){ //process last element
				top2=b;
				height=Math.min(A[top1], A[top2]);
				for(int j=top1+1;j<top2;j++){
					sum+=(height-A[j])>0?height-A[j]:0;
				}
			}
			else if(top2!=null){ //if there are tops process first
				if(A[b]>=A[top2])top2=b;
				height=Math.min(A[top1], A[top2]);
				for(int j=top1+1;j<top2;j++){
					sum+=(height-A[j])>0?height-A[j]:0;
				}
				find(A,top2,b);
			}else{
				top2=b;
				height=Math.min(A[top1], A[top2]);
				for(int j=top1+1;j<top2;j++){
					sum+=(height-A[j])>0?height-A[j]:0;
				}
			}
		}
		
	}

}
