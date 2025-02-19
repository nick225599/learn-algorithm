package org.nick.learn.leetcode.problem641;


import java.util.Arrays;

public class MyCircularDeque3 {
    // 模拟，官方题解
    //
    // front 为已使用的下标
    // rear 为待使用的下标
    // 不另外依赖 int size 来判断空或满
    private int[] elements;
    private int capacity;
    private int front; // 已使用的头下标
    private int rear; // 未使用的尾下标

    public MyCircularDeque3(int k) {
        elements = new int[k + 1];
        capacity = k + 1;
        front = rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return  elements[front];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
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
