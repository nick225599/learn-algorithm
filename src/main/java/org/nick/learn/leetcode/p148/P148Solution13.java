package org.nick.learn.leetcode.p148;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 作者：力扣官方题解
// 链接：https://leetcode.cn/problems/sort-list/solutions/492301/pai-xu-lian-biao-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class P148Solution13 {

    // 方法二：自底向上归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        // 计算节点总长度
        int length = this.calculateLength(head);

        ListNode dummyHead = new ListNode(0, head);

        // 将链表拆分成 1 节点一份、2 节点一份、4 节点一份、8 节点一份...
        for (int subLength = 1; subLength < length; subLength <<= 1) {

            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;

            while (curr != null) {

                // head1 指向第 1 份的头节点
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }

                // head2 指向第 2 份的头节点
                ListNode head2 = curr.next;
                curr.next = null; // 切断第 1 份和第 2 份
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null; // 将第 2 份与后续部分切断
                }

                // 合并第 1 份和第 2 份
                ListNode merged = merge(head1, head2);

                // 将合并结果和上一次 while 循环的合并结果给接上
                prev.next = merged;

                // 找到这一份的尾巴，作为下一次 while 循环执行结果要拼接的位置
                while (prev.next != null) {
                    prev = prev.next;
                }

                // 第 2 份尾节点的 next 节点，就是下一次 while 循环要处理的头节点
                curr = next;

                // 忒反直觉了
            }
        }
        return dummyHead.next;
    }

    private int calculateLength(ListNode head) {
        int l = 0;
        while(head != null){
            head = head.next;
            l++;
        }
        return l;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        node.next = left != null ? left : right;
        return dummy.next;
    }


}
