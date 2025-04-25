package org.nick.learn.leetcode.p23;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.list.ListNode;

/**
 * 力扣第 23 题
 */
@Slf4j
public class SolutionD {

    // 分治思维解题
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int startIndex, int endIndex) {
        if(startIndex > endIndex ){
            return null;
        }
        if(startIndex == endIndex){
            return lists[startIndex];
        }
        int midIndex = startIndex + ((endIndex - startIndex) >> 1);
        return mergeTwoListsV3(
                mergeKLists(lists, startIndex, midIndex),
                mergeKLists(lists, midIndex + 1, endIndex));
        //TODO nick_sun 20250117 2， 是否可以使用循环来解决分治产生的栈帧空间使用，降低空间使用率？
    }

    public ListNode mergeTwoListsV3(ListNode a, ListNode b) {
        ListNode head, tail;
        head = tail = new ListNode(0);
        ListNode aPtr = a, bPtr = b;
        while (null != aPtr && null != bPtr) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next; // suncs 20250127 会影响到已经赋值给 tail.next 的 l1 吗？
                // 不会，tail.next 已经存储好了当时赋值给它的 l1 对象地址（地址值1）
                // 当 l1 的引用地址被 l1 = l1.next 改变后，l1 的确是变化了（地址值1 变成了 地址值2）
                // 但是之前赋值给 tail.next 的值依旧是地址值1，这个不会变化，变化的只有形参 l1 的值

                // 官方题解为了避免代码维护人员产生上述这种疑虑或误解，
                // 额外生成了 ListNode aPtr = a, ListNode bPtr = b 用 aPtr 和 bPtr 来进行遍历
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = null == aPtr ? bPtr : aPtr;
        return head.next;
    }

    /**
     * @deprecated 比官方题解还是绕，继续尝试，不对 l1, l2 设置哨兵
     */
    @Deprecated
    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        ListNode head, tail;
        head = tail = new ListNode(-1);
        l1 = new ListNode(-1, l1);
        l2 = new ListNode(-1, l2);
        while (null != l1.next && null != l2.next) {
            if (l1.next.val < l2.next.val) {
                // 从 l1 中剥离出节点
                // 将剥离出的节点，续到 tail 后面
                ListNode tmp = l1.next;
                l1.next = l1.next.next;
                tail.next = tmp;
            } else {
                ListNode tmp = l2.next;
                l2.next = l2.next.next;
                tail.next = tmp;
            }
            tail = tail.next;
        }
        tail.next = (null == l1.next) ? l2.next : l1.next;
        return head.next;
    }

    /**
     * @deprecated 太绕了，应该参照官方题解，用一个头一个尾
     */
    @Deprecated
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        l1 = new ListNode(-1, l1);
        l2 = new ListNode(-1, l2);

        ListNode result = l1.next;

        while (null != l1.next && null != l2.next) {
            if (l1.next.val > l2.next.val) {
                // l2.next 要从 l2 中移除，插入到 l1 中

                // 从 l2 中移除
                ListNode tmp = l2.next;
                l2.next = l2.next.next;

                // 从 l1 中插入
                ListNode tmp2 = l1.next;
                l1.next = tmp;
                tmp.next = tmp2;
            }
            l1 = l1.next;
        }

        if (null == l1.next) {
            l1.next = l2.next;
        }

        return result;
    }
}
