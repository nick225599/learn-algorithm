package org.nick.learn.leetcode.p23;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.list.ListNode;

/**
 * 力扣第 23 题。分治思维解题，用迭代取代递归，降低栈空间使用
 *
 * 时间复杂度 O(logk * N)
 * 空间复杂度 O(1)
 */
@Slf4j
public class SolutionE {

    // 分治思维解题，迭代取代递归，代码可读性变差，但是空间复杂度从 O(logK)，优化为 O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        }
        int interval = 1; // 第一轮，两两合并，间隔为 1
        while (interval < lists.length) { // 等同于 interval <= lists.length/2
            for (int i = 0;
                 (i + interval) < lists.length;  // 每轮合并时，不用考虑 lists.length 是奇数还是偶数，奇数跳过最后一次合并就行
                 i += (interval << 1)) {
                lists[i] = mergeTwoListsV3(lists[i], lists[i + interval]);
            }
            interval <<= 1; // 第 2 轮开始，lists[0] 和 lists[2], lists[4] 和 lists[6] 合并，间隔为上一次间隔的 2 倍
                            // 以此类推，每轮间隔都是上一轮间隔的 2 倍
        }
        return lists[0];
    }

    public ListNode mergeTwoListsV3(ListNode a, ListNode b) {
        if (null == a || null == b) {
            return null == a ? b : a;
        }
        ListNode head, tail;
        head = tail = new ListNode(0);
        ListNode aPtr = a, bPtr = b;
        while (null != aPtr && null != bPtr) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = null == aPtr ? bPtr : aPtr;
        return head.next;
    }
}
