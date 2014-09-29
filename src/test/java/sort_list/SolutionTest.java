package sort_list;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafer@gmail.com
 */
public class SolutionTest {

	private Solution solution1 = new Solution();

	@Test
	public void test_empty_list() throws Exception {
		ListNode listNode = null;
		assertThat(solution1.sortList(listNode)).isEqualTo(listNode);
	}

	@Test
	public void test_one_node_list() throws Exception {
		ListNode listNode = new ListNode(5);
		assertThat(solution1.sortList(listNode)).isEqualTo(listNode);
	}

	@Test
	public void test_two_node_list() throws Exception {
		ListNode listNode = new ListNode(2);
		listNode.next = new ListNode(1);
		assertThat(solution1.sortList(listNode)).isNotEqualTo(listNode);
	}

	@Test
	public void test_3_node_list() throws Exception {
		ListNode listNode = new ListNode(3);
		listNode.next = new ListNode(4);
		listNode.next.next = new ListNode(1);
		assertThat(solution1.sortList(listNode)).isNotEqualTo(listNode);
	}
}
