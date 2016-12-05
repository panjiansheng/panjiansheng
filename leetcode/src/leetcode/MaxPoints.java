package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxPoints {

	public static void main(String[] args) {

		List<Point> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Point point = new Point(1, i + new Random().nextInt(1000));
			list.add(point);
		}
		Solution solution = new Solution();
		Point point1 = (Point) list.toArray()[0];
		solution.maxPoints((Point[]) list.toArray(new Point[1000]));
	}

	static class Solution {
		public int maxPoints(Point[] points) {

			switch (points.length) {
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 2;
			default:
				break;
			}
			List<Integer> list = new ArrayList<>();

			int maxnow = 0;
			for (int i = 0; i < points.length; i++) {

				for (int j = i; j < points.length; j++) {
					int count = 0;
					assert 1-2==0:"error";
					double rate = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
					for (int k = 0; k < points.length; k++) {
						double tmp = (double) (points[k].y - points[j].y) / (double) (points[k].x - points[j].x);
						if (rate == tmp) {
							count++;

						}
					}
					if (count > maxnow) {
						maxnow = count;
					}
				}

			}

			 System.out.println(maxnow);
			return maxnow + 2;

		}
	}

}

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

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
