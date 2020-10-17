package leetcode.companies.amazon;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNums {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode fakeHead = new ListNode();
        ListNode curr = fakeHead;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) +
                    (l2 == null ? 0 : l2.val) +
                    carryOver;
            if (sum > 9) {
                sum = sum % 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }
            ListNode node = new ListNode(sum);
            curr.next = node;
            curr = node;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carryOver == 1) {
            ListNode node = new ListNode(1);
            curr.next = node;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        AddTwoNums a = new AddTwoNums();
        System.out.println(
                a.addTwoNumbers(
                        new ListNode(9, new ListNode(9, new ListNode(9))),
                        new ListNode(9)
                )
        );
    }

}
