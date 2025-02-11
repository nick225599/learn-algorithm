package org.nick.learn.leetcode.problem23;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.list.ListNode;

/**
 * 自己拍脑袋想出来的利用小顶堆
 * 时间复杂度 O(logk * N)
 * 空间复杂度应该是 O(k)
 * <p>
 * 看看官方题解呢。。。
 */
@Slf4j
public class SolutionA {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        if (k == 1) {
            return lists[0];
        }

        // 建堆的时候无法处理稀疏 lists 还是要进行一次 O(k) 的遍历
        ListNode[] heap = new ListNode[k];
        int indexOfHeap = 0;
        for (int i = 0; i < k; i++) {
            if (null != lists[i]) {
                heap[indexOfHeap++] = lists[i];
            }
        }
        k = indexOfHeap;

        // 将 k 个元素取出来建立一个小顶堆 O(logk)
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(heap, k, i);
        }


        ListNode head = null;
        ListNode tail = null;


        ListNode minNode;

        // 取出元素要执行 O(n) 次
        // 每次取出元素 + 放置新元素 2次 O(logk) 操作
        // 综合起来就是 O(Nlogk)
        while ((minNode = popTopNode(heap, k)) != null) {
            k--;
            // 将堆顶元素移除，用来构建新的链

            if (null == head) {
                head = minNode;
                tail = minNode;
            } else {
                tail.next = minNode;
                tail = minNode;
            }

            // 将被移除元素的下一个节点（如果有的话），添加堆中
            if (null != minNode.next) {
                addNode(heap, k, minNode.next);
                k++;
            }
        }
        return head;
    }

    /**
     * O(logk)
     */
    private void addNode(ListNode[] minHeap, int k, ListNode newNode) {
        minHeap[k] = newNode;

        int parentIndex = (k - 1) / 2;
        while (true) {
            heapify(minHeap, k + 1, parentIndex);
            if (parentIndex == 0) {
                return;
            }
            parentIndex = (parentIndex - 1) / 2;
        }

    }

    /**
     * O(logk)
     */
    private ListNode popTopNode(ListNode[] heap, int k) {
        if (null == heap[0]) {
            return null;
        }
        ListNode topNode = heap[0];
        ListNode lastNode = heap[k - 1];

        // 把最后一个元素放到最顶部，然后从上往下重新堆化
        heap[0] = lastNode;
        heap[k - 1] = null;
        heapify(heap, k - 1, 0);
        return topNode;
    }

    private void heapify(ListNode[] heap, int k, int i) {
        int minIndex = i;

        int leftNodeIndex = 2 * i + 1;
        if (leftNodeIndex < k && heap[leftNodeIndex] != null
                && heap[leftNodeIndex].val < heap[minIndex].val) {
            minIndex = leftNodeIndex;
        }

        int rightNodeIndex = leftNodeIndex + 1;
        if (rightNodeIndex < k && heap[rightNodeIndex] != null
                && heap[rightNodeIndex].val < heap[minIndex].val) {
            minIndex = rightNodeIndex;
        }

        if (minIndex != i) {
            ListNode tmp = heap[i];
            heap[i] = heap[minIndex];
            heap[minIndex] = tmp;


            heapify(heap, k, minIndex);
        }
    }
}
