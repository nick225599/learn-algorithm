package org.nick.learn.leetcode.problem641;


//TODO nick_sun 20250218 写到一半，发现用 frontIndex 和 lastIndex 也有点问题
// frontIndex 表示已使用的位置，
// lastIndex 表示待插入的位置，
// 官方题解用一个已写入的位置和一个未接入的位置，判断是不是满了isEmpty isFull的逻辑，感觉也怪怪的，没能理解
public class MyCircularDeque1 {

    int[] arr;
    int length;
    int frontIndex = 0, lastIndex = 0; // 已插入的位置

    // 官方题解使用双指针，避免了自己想出来的题解需要 hasBeenUsed 相关判断逻辑的问题
    // 尝试着自己也写一下
    public MyCircularDeque1(int length) {
        this.arr = new int[length];
        this.length = length;

    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        frontIndex = fixIndex(frontIndex - 1);
        arr[frontIndex] = value;

        return true;
    }


    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        lastIndex = fixIndex(lastIndex + 1);
        arr[lastIndex] = value;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        frontIndex = fixIndex(frontIndex + 1);

        return true;

    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        lastIndex = fixIndex(lastIndex - 1);
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[frontIndex];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[lastIndex];
    }

    public boolean isEmpty() {
        return frontIndex == lastIndex;
    }

    public boolean isFull() {
        return false;
    }

    private int fixIndex(int i) {
        if (i < 0) {
            return i + length;
        }
        if (i > length - 1) {
            return i - length;
        }
        return i;
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
