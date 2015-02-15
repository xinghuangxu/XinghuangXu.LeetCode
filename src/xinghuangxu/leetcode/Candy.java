package xinghuangxu.leetcode;

public class Candy {

	public static void main(String[] args) {
		int N=2;
		int[] ratings=new int[N];
		for(int i=0;i<N;i++){
			ratings[i]=i+1;
		}
		Candy c=new Candy();
		System.out.println(c.candy(ratings));
	}
	
	public int candy(int[] ratings){
		if(ratings.length==1)return 1;
		int N=ratings.length;
		int[] distributions=new int[N];
		for(int i=0;i<N;i++){
			distributions[i]=1;
		}
		for(int i=1;i<N;i++){
			if(ratings[i]>ratings[i-1]){
				distributions[i]=distributions[i-1]+1;
			}
		}
		for(int i=N-1;i>0;i--){
			if(ratings[i-1]>ratings[i]){
				distributions[i-1]=Math.max(distributions[i-1], distributions[i]+1);
			}
		}
		int sum=0;
		for(int i=0;i<N;i++){
			sum+=distributions[i];
		}
		return sum;
		
	}

	public int candy1(int[] ratings) {
		if(ratings.length==1)return 1;
		int N=ratings.length;
		int[] distributions=new int[N];
		boolean finish=false;
		distributions[0]=1;
		for(int i=1;i<N;i++){
			if(ratings[i]>ratings[i-1]){
				distributions[i]=distributions[i-1]+1;
			}else{
				distributions[i]=1;
			}
		}
		while(!finish){
			finish=true;
			for(int i=0;i<N;i++){
				if(i<N-1&&ratings[i]>ratings[i+1]&&distributions[i]<=distributions[i+1]){
					distributions[i]=distributions[i+1]+1;
					finish=false;
				}
				if(i>0&&ratings[i]>ratings[i-1]&&distributions[i]<=distributions[i-1]){
					distributions[i]=distributions[i-1]+1;
					finish=false;
				}
			}
		}
		int sum=0;
		for(int i : distributions){
			sum+=i;
		}
		return sum;
		
	}
}
