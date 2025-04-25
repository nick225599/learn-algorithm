package org.nick.learn.leetcode.p641;


public class MyCircularDeque4 {

    int[] elements;
    int capacity;

    // 把 front rear 都当作已使用的下标来处理
    // 或者把 front rear 都当作待使用的下标来处理

    // 必须增加 size 来辅助判断 isEmpty 及 isFull
    // 避免不了在 insert 时对插入第一个元素时的特殊处理

    // java.util.ArrayDeque 用的是官方题解的方案
    int front,rear; // 假设此时为已使用的下标

    int size;

    public MyCircularDeque4(int k) {
        this.elements = new int[k];
        this.capacity = k;
        front = rear = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        size++;

        front = (front - 1 + capacity) % capacity;
        elements[front] = value;

        if(size == 1){
            rear = front;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        size++;

        rear = (rear + 1) % capacity;
        elements[rear] = value;

        if(size == 1){
            front = rear;
        }

        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        size--;

        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        size--;

        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return elements[front];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return elements[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
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
