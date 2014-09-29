package max_points_on_a_line;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafer@gmail.com
 */
public class SolutionTest {

	private Solution solution = new Solution();

	@Test
	public void test_three_point() throws Exception {
		Point[] points = new Point[] { new Point(0, 0), new Point(-1, -1), new Point(2, 2) };
		assertThat(solution.maxPoints(points)).isEqualTo(3);
		points = new Point[] { new Point(0, 0), new Point(1, 1), new Point(1, -1) };
		assertThat(solution.maxPoints(points)).isEqualTo(2);
	}

	@Test
	public void test_same_point() throws Exception {
		Point[] points = new Point[] { new Point(0, 0), new Point(1, 1), new Point(0, 0) };
		assertThat(solution.maxPoints(points)).isEqualTo(3);
	}

	@Test
	public void test_vertical_lines() throws Exception {
		Point[] points = new Point[] { new Point(0, -12), new Point(5, 2), new Point(2, 5), new Point(0, -5),
				new Point(1, 5), new Point(2, -2), new Point(5, -4), new Point(3, 4), new Point(-2, 4),
				new Point(-1, 4), new Point(0, -5), new Point(0, -8), new Point(-2, -1), new Point(0, -11),
				new Point(0, -9) };
		assertThat(solution.maxPoints(points)).isEqualTo(6);

	}

	@Test
	public void test_fraction() throws Exception {
		Solution.Fraction fraction1 = new Solution.Fraction(1, 2);
		Solution.Fraction fraction2 = new Solution.Fraction(2, 4);
		assertThat(fraction1).isEqualTo(fraction2);
	}
}
