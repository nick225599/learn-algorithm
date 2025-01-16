package org.nick.learn.leetcode.problem23;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.sort.heap.HeapPrinter;

@Slf4j
public class SolutionA {
    public ListNode mergeKLists(ListNode[] heap) {
        int k = heap.length;
        if (k == 0) {
            return null;
        }
        if (k == 1) {
            return heap[0];
        }

        // 将 k 个元素取出来建立一个小顶堆 O(logk)
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(heap, k, i);
        }

        HeapPrinter.printHeap(heap);

        ListNode newList = null;

        ListNode minNode;
        while ((minNode = popTopNode(heap)) != null) {
            // 将堆顶元素移除，用来构建新的链

            if (null == newList) {
                newList = minNode;
            } else {
                newList.next = minNode;
            }

            // 将被移除元素的下一个节点（如果有的话），添加堆中
            if (null != minNode.next) {
                addNode(heap, minNode.next);
            }
        }
        return newList;
    }

    /**
     * O(logk)
     */
    private void addNode(ListNode[] minHeap, ListNode newNode) {
        int index = minHeap.length - 1;
        minHeap[index] = newNode;

        index = (index - 1) / 2;
        while (true) {
            heapify(minHeap, minHeap.length, index);
            if (index == 0) {
                return;
            }
            index = (index - 1) / 2;
        }

    }

    /**
     * O(logk)
     */
    private ListNode popTopNode(ListNode[] heap) {
        if(null == heap[0]){
            return null;
        }
        ListNode topNode = heap[0];
        ListNode lastNode = heap[heap.length - 1];

        // 把最后一个元素放到最顶部，然后从上往下重新堆化
        heap[0] = lastNode;
        heap[heap.length - 1] = null;
        heapify(heap, heap.length - 1, 0);

        HeapPrinter.printHeap(heap);

        return topNode;
    }

    private void heapify(ListNode[] heap, int k, int i) {
        int minIndex = i;

        try {
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
        } catch (Exception e) {
            log.error("minIndex: {}", minIndex);
            log.error(e.getMessage(), e);
        }
    }
}
