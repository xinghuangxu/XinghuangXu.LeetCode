package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPointsOnALine {

	public static void main(String[] arg) {
		MaxPointsOnALine mpo = new MaxPointsOnALine();
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(2, 3));
		points.add(new Point(3, 3));
		points.add(new Point(-5, 3));
//		points.add(new Point(84, 250));
//		points.add(new Point(0, 0));
//		points.add(new Point(1, 0));
//
//		points.add(new Point(0, -70));
//		points.add(new Point(0, -70));
//		points.add(new Point(1, -1));
//
//		points.add(new Point(21, 10));
//		points.add(new Point(42, 90));
//		points.add(new Point(-42, -230));
		// for(int i=0;i<2;i++){
		// points.add(new Point(0,i));
		// }
		Point[] tempPoints = new Point[points.size()];
		for (int i = 0; i < points.size(); i++) {
			tempPoints[i] = points.get(i);
		}
		System.out.println(mpo.maxPoints(tempPoints));
	}

	public class Line {
		public int a;
		public int b;
		public int c;

		public Line(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public String getHashKey() {
			if (a == 0 || b == 0) {
				return a + ":" + b + ":" + c;
			} else {
				return b / (double) a + ":" + c;
			}

		}
	}

	/*
	 * Online Solution 1. for each point, find the line that pass it and have
	 * the most other points on it 2. get the maximum of 1
	 */
	public int maxPoints(Point[] points) {
		if(points.length<=2)return points.length;
		int result = 1, repeat, max;
		double k;
		HashMap<Double, Integer> map;
		for (int i = 0; i < points.length-1; i++) {
			map = new HashMap<Double, Integer>();
			repeat = 1;
			for (int j = i + 1; j < points.length; j++) { // j only has to start
															// with i+1 because
															// the other one has
															// counted
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						repeat++;
					} else {
						// on line parallel to y
						if (map.containsKey(Double.POSITIVE_INFINITY)) {
							map.put(Double.POSITIVE_INFINITY,
									map.get(Double.POSITIVE_INFINITY)+1);
						} else {
							map.put(Double.POSITIVE_INFINITY, 1);
						}
					}
				} else {
					k = (points[i].y - points[j].y) / (double)( points[i].x
							- points[j].x);
					if(k==0)k=0;
					if (map.containsKey(k)) {
						map.put(k, map.get(k) + 1);
					} else {
						map.put(k, 1);
					}
				}
			}
			max = 1;
			Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Double, Integer> pairs = (Entry<Double, Integer>) it
						.next();
				if (pairs.getValue() > max) {
					max = pairs.getValue();
				}
				it.remove(); // avoids a ConcurrentModificationException
			}
			max += repeat;
			result = max > result ? max : result;

		}
		return result;
	}

	/*
	 * My Solution: a lot of code not good
	 */
	public int maxPoints2(Point[] points) {
		if (points.length <= 2)
			return points.length; // no points
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Line line;
		int count = 0;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				line = findLine(points[i], points[j]);
				if (line != null && !map.containsKey(line.getHashKey())) {
					count = 2;
					for (int m = 0; m < points.length; m++) {
						if (m != i && m != j) {
							if (isOnLine(points[m], line)) {
								count++;
							}
						}
					}
					map.put(line.getHashKey(), count);
				}
			}
		}
		if (map.size() == 0)
			return points.length;
		int max = 1;
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Double, Integer> pairs = (Entry<Double, Integer>) it
					.next();
			if (pairs.getValue() > max) {
				max = pairs.getValue();
			}
			it.remove(); // avoids a ConcurrentModificationException
		}
		return max;
	}

	private boolean isOnLine(Point point, Line l) {
		if (l.b * point.x + l.c == l.a * point.y)
			return true;
		return false;
	}

	private Line findLine(Point point, Point point2) {
		int b = point.y - point2.y;
		int a = point.x - point2.x;
		if (a == 0 && b == 0)
			return null;
		int c = a * point.y - b * point.x;
		return new Line(a, b, c);
	}
}
