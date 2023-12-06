package leetcode.medium_143_reorder_list;

import leetcode.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        reorderList(l1);
    }

    // time complexity O(1) space complexity O(n)
    public static void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode iterator = head;
        while (iterator != null) {
            deque.addLast(iterator);
            iterator = iterator.next;
        }
        iterator = deque.removeFirst();
        boolean swtch = true;
        while (!deque.isEmpty()) {
            if (swtch) {
                iterator.next = deque.removeLast();

            } else {
                iterator.next = deque.removeFirst();
            }
            iterator = iterator.next;
            swtch = !swtch;
        }
        iterator.next = null;
    }

    // time complexity O(1) space complexity O(1)
    public void reorderList2(ListNode head) {

        // fast & slow approach to find middle of the list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // merge the two halves
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}