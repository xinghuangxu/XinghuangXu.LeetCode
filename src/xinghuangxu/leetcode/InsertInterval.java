package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

import xinghuangxu.leetcode.Helper.Interval;

public class InsertInterval {

	public static void main(String[] args) {
//		int[] x={1,3,6,8,12};
//		int[] y={2,5,7,10,16};
		int[] x={1};
		int[] y={5};
		List<Interval> intervals=new ArrayList<Interval>();
		for(int i=0;i<x.length;i++){
			intervals.add(new Interval(x[i],y[i]));
		}
		InsertInterval mi=new InsertInterval();
		List<Interval> rel=mi.insert(intervals,new Interval(2,3));
		System.out.println(rel.size());
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		int N = intervals.size();
		int j;
		for ( j = 0; j < N; j++) {
			if(intervals.get(j).start>=newInterval.start){
				intervals.add(j,newInterval);
				break;
			}
		}
		if(j==N){
			intervals.add(newInterval);
		}
		for (int i = 0; i < N+1; i++) {
			Interval temp = intervals.get(i);
			if (i < N  && temp.end >= intervals.get(i+1).start) {
				temp = MergeInterval(temp, intervals.get(i+1));
			} else {
				result.add(temp);
			}
		}
		return result;
	}

	private Interval MergeInterval(Interval i1, Interval i2) {
		i2.start=i1.start;
		i2.end = Math.max(i2.end, i1.end); // need to get the max of the two
											// since sorting them is not going
											// to help with that.
		return i2;
	}
}
