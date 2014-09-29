package sort_list;

/**
 * quick sort
 *
 * @author code4crafer@gmail.com
 */
public class Solution1 {

	private class List {
		ListNode head;
		ListNode tail;

		private List(ListNode head) {
			this.head = head;
			this.tail = head;
		}

		private List(ListNode head, ListNode tail) {
			this.head = head;
			this.tail = tail;
		}

		void appendTail(ListNode node) {
			this.tail.next = node;
			this.tail = node;
		}

		void appendTail(List list) {
			tail.next = list.head;
			tail = list.tail;
			tail.next = null;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode tail = head.next;
		while (tail != null) {
			tail = tail.next;
		}
		return sort(new List(head, tail)).head;
	}

	private List sort(List list) {
		if (list.head == list.tail) {
			return list;
		}
		ListNode parti = list.head;
		List left = null;
		List right = null;
		ListNode currentNode = list.head.next;
		while (currentNode != null) {
			if (currentNode.val <= parti.val) {
				if (left == null) {
					left = new List(currentNode);
				} else {
					left.appendTail(currentNode);
				}
			} else {
				if (right == null) {
					right = new List(currentNode);
				} else {
					right.appendTail(currentNode);
				}
			}
			currentNode = currentNode.next;
		}
		List result = null;
		if (left != null) {
			left = sort(left);
			result = new List(left.head, left.tail);
		}
		if (result != null) {
			result.appendTail(parti);
		} else {
			result = new List(parti);
		}
		if (right != null) {
			right = sort(right);
			result.appendTail(right);
		}
		return result;
	}
}
