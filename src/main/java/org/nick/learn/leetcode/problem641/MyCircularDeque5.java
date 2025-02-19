package org.nick.learn.leetcode.problem641;


public class MyCircularDeque5 {

    int size;
    int capacity;
    DequeNode frontNode;
    DequeNode rearNode;

    static class DequeNode {
        int value;
        DequeNode front;
        DequeNode rear;

        public DequeNode(int value) {
            this.value = value;
        }

        public DequeNode(int value, DequeNode front, DequeNode rear) {
            this.value = value;
            this.front = front;
            this.rear = rear;
        }

        public void setFront(DequeNode front) {
            this.front = front;
        }

        public void setRear(DequeNode rear) {
            this.rear = rear;
        }
    }


    public MyCircularDeque5(int k) {
        this.capacity = k;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            DequeNode node = new DequeNode(value);
            frontNode = rearNode = node;
        } else {
            frontNode = new DequeNode(value, null, frontNode);
            frontNode.rear.front = frontNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            DequeNode node = new DequeNode(value);
            frontNode = rearNode = node;
        } else {
            rearNode = new DequeNode(value, rearNode, null);
            rearNode.front.rear = rearNode;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        frontNode = frontNode.rear;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rearNode = rearNode.front;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return frontNode.value;

    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return rearNode.value;
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
