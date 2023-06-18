package leetcode.medium_19_remove_nth_node_from_end_of_list;

import java.util.Objects;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5))));
        solve(head, 2, expected);
        ListNode head2 = new ListNode(1);
        solve(head2, 1, null);
        ListNode head3 = new ListNode(1, new ListNode(2));
        ListNode expected3 = new ListNode(2);
        solve(head3, 2, expected3);
    }

    private static void solve(ListNode head, int n, ListNode expected) {
        ListNode actual = Solution.removeNthFromEnd(head, n);
        System.out.print("input    = ");
        System.out.print("head = " + head);
        System.out.println(" n = " + n);
        System.out.println("expected = " + expected);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sizeTemp = head;
        int size = 1;
        ListNode iterator = sizeTemp;
        while (iterator.next != null) {
            iterator = iterator.next;
            size++;
        }
        ListNode modifyTemp = head;
        for (int i = 0; i < size - n - 1; i++) {
            modifyTemp = modifyTemp.next;
        }
        if (size == n) {
            return head.next;
        }
        modifyTemp.next = modifyTemp.next.next;
        return head;
    }
}

class ListNode {
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

    @Override
    public String toString() {
        return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("next=" + next)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode listNode)) return false;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
