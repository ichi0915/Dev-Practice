/**
 * This file contains the Add Two Numbers Function.
 *
 * <p>Exercise: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * 		The number of nodes in each linked list is in the range [1, 100].
 * 		0 <= Node.val <= 9
 * 		It is guaranteed that the list represents a number that does not have leading zeros.
 *
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 */

/**
 * Main Class for the AddTwoNumbers
 */
class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(final String[] args) {
		// Response: [7,0,8]
		// ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		// ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

		// Response: [8,9,9,9,0,0,0,1]
		ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

		ListNode l3 = addTwoNumbers(l1, l2);

		printListNode(l1);
		printListNode(l2);
		printListNode(l3);
	}

	// Auxiliary methods

	public static void printListNode(ListNode list) {
		while (null != list.next) {
			System.out.print(list.val + " --> ");
			list = list.next;
		}
		System.out.print(list.val + "\n");
	}

	// First pos is carry and second is sum value
	public static int[] getVal(int val1, int val2, int carry) {
		int val[] = {0, 0};

		val[1] = val1 + val2 + carry;
		if (val[1] >= 10) {
			val[1] -= 10;
			val[0] = 1;
		}

		return val;
	}

	// addTwoNumbers

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean notFirstLoop = false;
		int carry = 0;
		ListNode head = new ListNode();
		ListNode response = head;

		while (null != l1 || null != l2 || 0 != carry) {

			if (notFirstLoop) {
				head.next = new ListNode();
				head = head.next;
			}

			int digit1 = (null != l1) ? l1.val : 0;
			int digit2 = (null != l2) ? l2.val : 0;

			int[] valArray = getVal(digit1, digit2, carry);
			carry = valArray[0];
			head.val = valArray[1];

			l1 = (null != l1) ? l1.next : null;
			l2 = (null != l2) ? l2.next : null;

			notFirstLoop = true;
		}

		return response;
	}


	// ======== Old version ========

	public static ListNode addTwoNumbersNotOptimal(ListNode l1, ListNode l2) {
		boolean notFirstLoop = false;
		int carry = 0;
		ListNode head = new ListNode();
		ListNode response = head;

		while (null != l1 || null != l2) {

			if (notFirstLoop) {
				head.next = new ListNode();
				head = head.next;
			}

			if (null != l1 && null != l2) {
				int[] valArray = getVal(l1.val, l2.val, carry);
				carry = valArray[0];

				// System.out.print(valArray[1]);

				head.val = valArray[1];
				l1 = l1.next;
				l2 = l2.next;
			}
			else if (null != l1) {
				int[] valArray = getVal(l1.val, 0, carry);
				carry = valArray[0];

				head.val = valArray[1];
				l1 = l1.next;
			}
			else if (null != l2) {
				int[] valArray = getVal(0, l2.val, carry);
				carry = valArray[0];

				head.val = valArray[1];
				l2 = l2.next;
			}

			notFirstLoop = true;
		}

		if (0 != carry) {
			head.next = new ListNode();
			head = head.next;
			head.val = 1;
		}
		// System.out.println("");

		return response;
	}

}
