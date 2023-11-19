package leetcode.easy_206_reverse_linked_list;

import leetcode.util.ListNode;

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
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode actual = reverseList(input);
        System.out.println("actual = " + actual);
    }

    /*
        Input:  [1,2,3,4,5]
        Output: [5,4,3,2,1]
    */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode crr = head;

        while (crr != null) {
            ListNode nextCrr = crr.next;
            crr.next = prev;
            prev = crr;
            crr = nextCrr;
        }

        return prev;
    }
}