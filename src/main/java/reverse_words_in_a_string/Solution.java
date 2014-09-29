package reverse_words_in_a_string;

/**
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
 *
 * @author code4crafer@gmail.com
 */
public class Solution {

	public String reverseWords(String s) {
		String[] strings = s.split("\\s+");
		if (strings.length <= 1) {
			return s.trim();
		}
		StringBuilder accum = new StringBuilder();
		for (int i = strings.length - 1; i > 0; i--) {
			accum.append(strings[i]).append(" ");
		}
		return accum.append(strings[0]).toString().trim();
	}

}