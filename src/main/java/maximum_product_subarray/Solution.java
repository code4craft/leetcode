package maximum_product_subarray;

/**
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 *
 * @author code4crafer@gmail.com
 */
public class Solution {

	private class Context {
		int maxProduct = Integer.MIN_VALUE;
		int productMinus = Integer.MIN_VALUE;
		int product = Integer.MIN_VALUE;

		private Context() {
			init();
		}

		void init() {
			productMinus = Integer.MIN_VALUE;
			product = Integer.MIN_VALUE;
		}

		void calc(int m) {
			if (m == 0) {
				if (maxProduct < 0) {
					maxProduct = 0;
				}
				init();
			} else if (m > 0) {
				multipProduct(m);
				multipMinusProduct(m);
				if (product > maxProduct) {
					maxProduct = product;
				}
			} else {
				multipMinusProduct(m);
				if (productMinus > product) {
					product = productMinus;
				} else {
					product = 0;
				}
				if (product > maxProduct) {
					maxProduct = product;
				}
			}
		}

		void multipProduct(int m) {
			if (product == Integer.MIN_VALUE) {
				product = m;
			} else {
				product *= m;
			}
		}

		void multipMinusProduct(int m) {
			if (productMinus == Integer.MIN_VALUE) {
				productMinus = m;
			} else {
				productMinus *= m;
			}
		}

	}

	public int maxProduct(int[] A) {
		Context contextForward = new Context();
		for (int i = 0; i < A.length; i++) {
			contextForward.calc(A[i]);
		}
		Context contextBackward = new Context();
		for (int i = A.length - 1; i >= 0; i--) {
			contextBackward.calc(A[i]);
		}
		return Math.max(contextForward.maxProduct, contextBackward.maxProduct);
	}

}
