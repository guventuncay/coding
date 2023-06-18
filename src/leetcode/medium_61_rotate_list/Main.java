package leetcode.medium_61_rotate_list;

import java.util.Objects;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(2, new ListNode(3)))));
        solve(head, 2, expected);
        ListNode head1 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode expected1 = new ListNode(2, new ListNode(0, new ListNode(1)));
        solve(head1, 4, expected1);
    }

    private static void solve(ListNode head, int n, ListNode expected) {

        System.out.print("input    = ");
        System.out.print("head = " + head);
        System.out.println(" n = " + n);
        ListNode actual = Solution.rotateRight(head, n);
        System.out.println("actual   = " + actual);
        System.out.println("expected = " + expected);
        System.out.println("result   = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode start = head;
        ListNode end = head;

        for (int i = 0; i < k; i++) {
            if (start.next == null) {
                start = head;
                continue;
            }
            start = start.next;
        }

        while (start.next != null) {
            start = start.next;
            end = end.next;
        }

        start.next = head;
        ListNode rtrn = end.next;
        end.next = null;

        return rtrn;
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
