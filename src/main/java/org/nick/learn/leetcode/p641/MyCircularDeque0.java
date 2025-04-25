package org.nick.learn.leetcode.p641;

public class MyCircularDeque0 {

    int[] content;
    int length;
    int size = 0;

    boolean hasBeenUsed = false;
    int index = 0; // 已使用的头部下标


    public MyCircularDeque0(int length) {
        this.length = length;
        this.content = new int[length];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (hasBeenUsed) {
            index = index - 1;
            index = correctIndex(index);
        }
        content[index] = value;

        size++;

        hasBeenUsed = true;

        return true;
    }



    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        int tmp = index;
        if(hasBeenUsed){
            tmp = index + size;
            tmp = correctIndex(tmp);
        }
        content[tmp] = value;

        size++;

        hasBeenUsed = true;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        index = index + 1;
        index = correctIndex(index);

        size--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        size--;

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return content[index];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        int tmp = index + size - 1;
        tmp = correctIndex(tmp);

        return content[tmp];
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean isFull() {
        return size >= length;
    }

    private int correctIndex(int index) {
        if (index >= length) {
            index = index - length;
        } else if (index < 0) {
            index = index + length;
        }
        return index;
    }

/**
 * Your MyCircularDeque0 object will be instantiated and called as such:
 * MyCircularDeque0 obj = new MyCircularDeque0(k);
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
