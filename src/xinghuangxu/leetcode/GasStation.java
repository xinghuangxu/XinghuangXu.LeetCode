package xinghuangxu.leetcode;
import java.util.HashMap;


public class GasStation {

	public static void main(String[] args) {
		int[] gas={6,1,4,3,5};
		int[] cost={3,8,2,4,2};
		GasStation gs=new GasStation();
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int N=gas.length,index=0,sum=0,dif,excess=0;
		boolean reset=false;
		for(int i=0;i<N;i++){
			dif=gas[i]-cost[i];
			sum+=dif;
			excess+=dif;
			if(reset&&dif>0){
				index=i;
				reset=false;
			}
			if(excess<0&&dif<0){
				reset=true;
				excess=0;
			}
		}
		if(sum>=0){
			return index;
		}
		return -1;
	}
	
	
	HashMap<String,Integer> map=new HashMap<String, Integer>();
	
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int N=gas.length,minCost=0;
		for(int s=0;s<N;s++){
			minCost=getMinCost(s, s+N-1, gas, cost, N);
			if(minCost<=0){
				return s;
			}
		}
		return -1;
	}
	
	public int getMinCost(int i,int j, int[] gas, int[] cost,int size){
		Integer minCost=map.get(i+":"+j),curCost;
		if(minCost==null){
			if(i==j){
				minCost=cost[i%size]-gas[i%size];
			}else{
				curCost=cost[i%size]-gas[i%size];
				minCost=Math.max(curCost,curCost+getMinCost(i+1,j,gas,cost,size));
			}
			map.put(i+":"+j, minCost);
		}
		return minCost;
	}


	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int N=gas.length,gasLeft=0,i;
		for(int s=0;s<N;s++){
			if(cost[s]<=gas[s]){
				gasLeft=gas[s]-cost[s];i=s+1;
				while(i%N!=s&&gasLeft>=0){
					gasLeft+=gas[i%N];
					gasLeft-=cost[i%N];
					i++;
				}
				if(i%N==s){
					return s;
				}
			}
			
		}
		return -1;
	}

}
