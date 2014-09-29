package reverse_words_in_a_string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafer@gmail.com
 */
public class SolutionTest {

	private Solution solution = new Solution();

	@Test
	public void test_simple_reverse() throws Exception {
		assertThat(solution.reverseWords("the sky is blue")).isEqualTo("blue is sky the");
	}
}
