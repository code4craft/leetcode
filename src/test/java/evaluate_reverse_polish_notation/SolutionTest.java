package evaluate_reverse_polish_notation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafer@gmail.com
 */
public class SolutionTest {
	
	private Solution solution = new Solution();

	@Test
	public void test_solution() throws Exception {
		assertThat(solution.evalRPN(new String[] { "2", "1", "+", "3", "*" })).isEqualTo(9);
		assertThat(solution.evalRPN(new String[] { "4", "13", "5", "/", "+" })).isEqualTo(6);
	}
}
