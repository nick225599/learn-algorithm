package org.nick.learn.leetcode.p239;

public class Solution9 {

    // 自己手写一个双端队列
    static class MyArrayDeque {
        private final int capacity;
        private final int[] elements;
        private int firstIndex, lastIndex; // firstIndex 已插入，lastIndex 未插入

        public MyArrayDeque(int capacity) {
            this.capacity = capacity + 1;
            this.elements = new int[capacity + 1];
            firstIndex = lastIndex = 0;
        }


        public void addFirst(Integer integer) {
            if (null == integer) {
                throw new NullPointerException("input is null");
            }
            if (isFull()) {
                throw new IllegalStateException("deque is full");
            }
            firstIndex = (firstIndex - 1 + capacity) % capacity;
            elements[firstIndex] = integer;
        }


        public void addLast(Integer integer) {
            if (null == integer) {
                throw new NullPointerException("input is null");
            }
            if (isFull()) {
                throw new IllegalStateException("deque is full");
            }
            elements[lastIndex] = integer;
            lastIndex = (lastIndex + 1) % capacity;
        }


        public boolean offerFirst(Integer integer) {
            if (null == integer) {
                throw new NullPointerException("input is null");
            }
            if (isFull()) {
                return false;
            }
            firstIndex = (firstIndex - 1 + capacity) % capacity;
            elements[firstIndex] = integer;
            return true;
        }


        public boolean offerLast(Integer integer) {
            if (null == integer) {
                throw new NullPointerException("input is null");
            }
            if (isFull()) {
                return false;
            }
            elements[lastIndex] = integer;
            lastIndex = (lastIndex + 1) % capacity;
            return true;
        }


        public Integer removeFirst() {
            if (isEmpty()) {
                throw new RuntimeException("deque is empty");
            }
            int result = elements[firstIndex];
            firstIndex = (firstIndex + 1) % capacity;
            return result;
        }


        public Integer removeLast() {
            if (isEmpty()) {
                throw new RuntimeException("deque is empty");
            }
            lastIndex = (lastIndex - 1 + capacity) % capacity;
            int result = elements[lastIndex];
            return result;
        }


        public Integer pollFirst() {
            if (isEmpty()) {
                return null;
            }
            int result = removeFirst();
            return result;
        }


        public Integer pollLast() {
            if (isEmpty()) {
                return null;
            }
            int result = removeLast();
            return result;
        }


        public Integer getFirst() {
            if (isEmpty()) {
                throw new RuntimeException("deque is empty");
            }
            return elements[firstIndex];
        }


        public Integer getLast() {
            if (isEmpty()) {
                throw new RuntimeException("deque is empty");
            }
            return elements[(lastIndex - 1 + capacity) % capacity];
        }


        public Integer peekFirst() {
            if (isEmpty()) {
                return null;
            }
            return getFirst();
        }


        public Integer peekLast() {
            if (isEmpty()) {
                return null;
            }
            return getLast();
        }


        public boolean removeFirstOccurrence(Object o) {
            if (null == o) {
                throw new NullPointerException("param is null");
            }
            if (o.equals(peekFirst())) {
                removeFirst();
                return true;
            }
            return false;
        }


        public boolean removeLastOccurrence(Object o) {
            if (null == o) {
                throw new NullPointerException("param is null");
            }
            if (o.equals(peekLast())) {
                removeLast();
                return true;
            }
            return false;
        }


        public boolean add(Integer integer) {
            addLast(integer);
            return true;
        }


        public boolean offer(Integer integer) {
            return offerLast(integer);
        }


        public Integer remove() {
            return removeFirst();
        }


        public Integer poll() {
            return pollFirst();
        }


        public Integer element() {
            return getFirst();
        }


        public Integer peek() {
            return peekFirst();
        }


        public void push(Integer integer) {
            addFirst(integer);
        }


        public Integer pop() {
            return removeFirst();
        }


        public boolean remove(Object o) {
            return removeFirstOccurrence(o);
        }


        public int size() {
            if (firstIndex <= lastIndex) {
                return lastIndex - firstIndex;
            } else {
                return lastIndex + capacity - firstIndex;
            }
        }


        public boolean isEmpty() {
            return firstIndex == lastIndex;
        }

        private boolean isFull() {
            //TODO sunchuansheng 我记得可以通过 firstIndex 和 lastIndex 直接算出来
//            return size() >= capacity - 1;
            return (lastIndex + 1) % capacity == firstIndex;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MyArrayDeque deque = new MyArrayDeque(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            while (!deque.isEmpty() && nums[deque.peekFirst()] < element) {
                deque.pollFirst(); // 为啥不会误删？
                // 因为新加入的值注定有效期比删除的值更久，且值更大，
                // 所以轮不到被踢出的值成为窗口最大值
            }
            deque.offerFirst(i);
            if (i - k + 1 >= 0) {

                // 删除失效元素
                while (deque.peekLast() < i - k + 1) {
                    deque.pollLast();
                }

                result[i - k + 1] = nums[deque.peekLast()];
            }
        }
        return result;
    }
}
