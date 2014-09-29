package evaluate_reverse_polish_notation;

import java.util.Stack;

/**
 * @author code4crafer@gmail.com
 */
public class Solution {

	enum Operator {
		ADD {
			@Override
			public int calc(int n1, int n2) {
				return n1 + n2;
			}
		}, SUB {
			@Override
			public int calc(int n1, int n2) {
				return n1 - n2;
			}
		}, MULTI {
			@Override
			public int calc(int n1, int n2) {
				return n1 * n2;
			}
		}, DIV {
			@Override
			public int calc(int n1, int n2) {
				return n1 / n2;
			}
		};

		public abstract int calc(int n1, int n2);

		public static Operator fromToken(String token) {
			if (("+").equals(token)) {
				return ADD;
			} else if ("-".equals(token)) {
				return SUB;
			} else if ("*".equals(token)) {
				return MULTI;
			} else if ("/".equals(token)) {
				return DIV;
			}
			return null;
		}
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			Operator operator = Operator.fromToken(token);
			if (operator == null) {
				stack.push(Integer.parseInt(token));
			} else {
				Integer n2 = stack.pop();
				Integer n1 = stack.pop();
				int calc = operator.calc(n1, n2);
				stack.push(calc);
			}
		}
		return stack.pop();
	}

}
