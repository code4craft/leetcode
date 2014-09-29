package maximum_product_subarray;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafer@gmail.com
 */
public class SolutionTest {

	private Solution solution = new Solution();

	@Test
	public void test_no_zero() throws Exception {
		assertThat(solution.maxProduct(new int[] { 2, 3, -2, 4 })).isEqualTo(6);
	}

	@Test
	public void test_has_zero() throws Exception {
		assertThat(solution.maxProduct(new int[] { 2, 3, -2, 4, 0, 4, 5, 0 })).isEqualTo(20);
	}

	@Test
	public void test_even_minus() throws Exception {
		assertThat(solution.maxProduct(new int[] { 2, 3, -2, 4, -1, 2 })).isEqualTo(96);
	}

	@Test
	public void test_odd_minus() throws Exception {
		assertThat(solution.maxProduct(new int[] { 2, 3, -2, 4, -1, 2, -1, 200 })).isEqualTo(1600);
	}

	@Test
	public void test_one_minus() throws Exception {
		assertThat(solution.maxProduct(new int[] { -2 })).isEqualTo(-2);
	}
}
