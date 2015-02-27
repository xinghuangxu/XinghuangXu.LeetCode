package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

import xinghuangxu.leetcode.Helper.Interval;

public class MergeIntervals {

	public static void main(String[] args) {
//		int[] x={2,1,8,15};
//		int[] y={6,3,10,18};
		int[] x={1,1};
		int[] y={4,5};
		List<Interval> intervals=new ArrayList<Interval>();
		for(int i=0;i<x.length;i++){
			intervals.add(new Interval(x[i],y[i]));
		}
		MergeIntervals mi=new MergeIntervals();
		List<Interval> rel=mi.merge(intervals);
		System.out.println(rel.size());
	}
	
//	public List<Interval> merge(List<Interval> intervals) {
//		
//	}
//	
//	private List<Interval> MergeSort(List<Interval> list,int lo,int hi) {
//		List<Interval> rel=new ArrayList<Interval>();
//		if(lo==hi){
//			rel.add(list.get(lo));
//		}
//		int mid=(lo+hi)/2;
//		List<Interval> leftSorted=MergeSort(list,lo,mid);
//		List<Interval> rightSorted=MergeSort(list,mid+1,hi);
//		int i=0,j=0;
//		while(i<=leftSorted.size()-1&&j<=rightSorted.size()-1){
//			if(isOverlapped(leftSorted.get(i),rightSorted.get(j))){
//				Merge(leftSorted.get(i),rightSorted.get(j));
//				j++;
//			}else{
//				
//			}
//		}
//	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		int N = intervals.size();
		Interval[] array=new Interval[N];
		for(int i=0;i<N;i++){
			array[i]=intervals.get(i);
		}
		MergeSort(array,0,N-1);
		for (int i = 0; i < N; i++) {
			Interval temp=array[i];
			if (i < N - 1
					&& temp.end >= array[i + 1].start) {
				temp=MergeInterval(temp,array[i+1]);
				array[i+1]=temp;
			}else{
				result.add(temp);
			}
		}
		return result;
	}
	
	private Interval MergeInterval(Interval i1, Interval i2) {
		i1.end=Math.max(i2.end,i1.end); //need to get the max of the two since sorting them is not going to help with that.
		return i1;
	}
	

	private void MergeSort(Interval[] list, int lo, int hi) {
		if(lo>=hi)return;
		int mid=(lo+hi)/2;
		MergeSort(list,lo,mid);
		MergeSort(list,mid+1,hi);
		int i=lo,j=mid+1;
		Interval[] rel=new Interval[hi-lo+1];
		int count=0;
		while(i<=mid&&j<=hi){
			if(list[i].start<list[j].start){
				rel[count]=list[i];
				i++;
			}else{
				rel[count]=list[j];
				j++;
			}
			count++;
		}
		while(i<=mid){
			rel[count]=list[i];
			i++;
			count++;
		}
		while(j<=hi){
			rel[count]=list[j];
			j++;
			count++;
		}
		for(int k=0;k<count;k++){
			list[lo+k]=rel[k];
		}
	}

	

}
