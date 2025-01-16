package org.nick.learn.leetcode.problem141;

/**
 * 怎么在空间复杂度 O(1) 下完成检查？
 * 完成了，
 * 但改变了 ListNode ，能在不改变的情况下处理吗？
 * <p>
 * Floyd 弗洛伊德判圈法
 */
public class SolutionC {

    public boolean hasCycle(ListNode head) {
        if(null == head || null == head.next){
            return false;
        }
        ListNode tortoiseNode = head;
        ListNode hareNode = head.next;
        while(true){
            if(tortoiseNode.equals(hareNode)){
                return true;
            }
            if(null == tortoiseNode.next){
                return false;
            }
            if(null == hareNode.next || null == hareNode.next.next){
                return false;
            }
            tortoiseNode = tortoiseNode.next;
            hareNode = hareNode.next.next;
        }
    }
}
