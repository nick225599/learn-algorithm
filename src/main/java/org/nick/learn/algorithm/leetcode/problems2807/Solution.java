package org.nick.learn.algorithm.leetcode.problems2807;

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
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().gcd0(18, 6));
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            curr.next = new ListNode(gcd0(curr.val, curr.next.val), curr.next);
            curr = curr.next.next;
        }
        return head;
    }

    // 辗转相除法（欧几里得算法）迭代实现
    public static int gcd0(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 辗转相除法（欧几里得算法）递归实现
    public int gcd1(int a, int b) {
        while (b != 0) {
            return gcd0(b, a % b);
        }
        return a;
    }

    // 更相减损法
    public int gcd2(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    // 穷举法
    public int gcd3(int a, int b) {
        for (int i = (a > b ? a : b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    static class ListNode {
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

}
