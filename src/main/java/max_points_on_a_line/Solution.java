package max_points_on_a_line;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/max-points-on-a-line/
 * <p/>
 * 时间复杂度O(n^2)，思路：先两两相连算出所有线，把线用两个分数表示，用约分的方法保证同一条线只有一种表示形式，再用这个形式的hash来做合并
 *
 * 注意点：
 * 1. 题目要求支持重复点，所以用数组序号来做equals
 * 2. 直线的一贯表示法为y=ax+b，但是需要考虑x=b这种情况
 *
 *
 * @author code4crafer@gmail.com
 */
public class Solution {

	/**                         y
	 * borrowed from http://stackoverflow.com/questions/474535/best-way-to-represent-a-fraction-in-java
	 */
	final static class Fraction {
		private final int numerator;
		private final int denominator;

		public int gcm(int a, int b) {
			return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
		}

		public Fraction(int numerator, int denominator) {
			if (denominator == 0) {
				this.numerator = 0;
				this.denominator = 0;
			} else {
				if (denominator < 0) {
					numerator *= -1;
					denominator *= -1;
				}
				int gcm = gcm(numerator, denominator);
				this.numerator = numerator / gcm;
				this.denominator = denominator / gcm;
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			Fraction fraction = (Fraction) obj;
			return numerator == fraction.numerator && denominator == fraction.denominator;
		}

		@Override
		public int hashCode() {
			return numerator * 31 + denominator;
		}
	}

	/**
	 * y1=ax1+b
	 * y2=ax2+b
	 * <p/>
	 * a=(y1-y2)/(x1-x2)
	 * b=(y1*(x1-x2)-(y1-y2)*x1)/(x1-x2)
	 */
	private static class Line {
		final Fraction a;
		final Fraction b;

		private Line(Fraction a, Fraction b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof Line)) {
				return false;
			}
			Line line = (Line) obj;
			return a.equals(line.a) && b.equals(line.b);
		}

		@Override
		public int hashCode() {
			return a.hashCode() * 17 + b.hashCode();
		}

		static Line fromPoints(Point point1, Point point2) {
			int subX = point1.x - point2.x;
			int subY = point1.y - point2.y;
			Fraction a = new Fraction(subY, subX);
			Fraction b;
			if (subX != 0) {
				b = new Fraction(point1.y * (subX) - point1.x * subY, subX);
			} else {
				b = new Fraction(point1.x, 1);
			}
			return new Line(a, b);
		}
	}

	private static class PointWrapper {
		int id;
		private Point point;

		private PointWrapper(int id, Point point) {
			this.id = id;
			this.point = point;
		}

		@Override
		public int hashCode() {
			return id;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			return ((PointWrapper) obj).id == id;
		}
	}

	public int maxPoints(Point[] points) {
		if (points.length <= 2) {
			return points.length;
		}
		Map<Line, Set<PointWrapper>> pointCount = new HashMap<Line, Set<PointWrapper>>();
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Line line = Line.fromPoints(points[i], points[j]);
				if (pointCount.get(line) == null) {
					pointCount.put(line, new HashSet<PointWrapper>());
				}
				pointCount.get(line).add(new PointWrapper(i, points[i]));
				pointCount.get(line).add(new PointWrapper(j, points[j]));
			}
		}
		int max = 0;
		for (Map.Entry<Line, Set<PointWrapper>> entry : pointCount.entrySet()) {
			if (entry.getValue().size() > max) {
				max = entry.getValue().size();
			}
		}
		return max;
	}

}
