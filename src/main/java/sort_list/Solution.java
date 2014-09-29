package sort_list;

/**
 * merge sort
 *
 * @author code4crafer@gmail.com
 */
public class Solution {

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		int size = 1;
		ListNode tail = head.next;
		while (tail != null) {
			size++;
			tail = tail.next;
		}
		return mergeSort(head, size);
	}

	private ListNode mergeSort(ListNode head, int size) {
		if (size <= 1) {
			return head;
		}
		int leftSize = size / 2;
		ListNode currentNode = head;
		for (int i = 1; i < leftSize; i++) {
			currentNode = currentNode.next;
		}
		ListNode rightHead = currentNode.next;
		currentNode.next = null;
		head = mergeSort(head, leftSize);
		int rightSize = size - leftSize;
		rightHead = mergeSort(rightHead, rightSize);
		return merge(head, rightHead);
	}

	private ListNode merge(ListNode leftHead, ListNode rightHead) {
		ListNode head = null;
		ListNode tail = head;
		while (leftHead != null && rightHead != null) {
			if (leftHead.val <= rightHead.val) {
				if (head == null) {
					head = leftHead;
					tail = leftHead;
					leftHead = leftHead.next;
					tail.next = null;
				} else {
					tail.next = leftHead;
					tail = leftHead;
					leftHead = leftHead.next;
					tail.next = null;
				}
			} else {
				if (head == null) {
					head = rightHead;
					tail = rightHead;
					rightHead = rightHead.next;
					tail.next = null;
				} else {
					tail.next = rightHead;
					tail = rightHead;
					rightHead = rightHead.next;
					tail.next = null;
				}
			}
		}
		while (leftHead != null) {
			if (head == null) {
				head = leftHead;
				tail = leftHead;
				leftHead = leftHead.next;
				tail.next = null;
			} else {
				tail.next = leftHead;
				tail = leftHead;
				leftHead = leftHead.next;
				tail.next = null;
			}
		}
		while (rightHead != null) {
			if (head == null) {
				head = rightHead;
				tail = rightHead;
				rightHead = rightHead.next;
				tail.next = null;
			} else {
				tail.next = rightHead;
				tail = rightHead;
				rightHead = rightHead.next;
				tail.next = null;
			}
		}
		return head;
	}

}
