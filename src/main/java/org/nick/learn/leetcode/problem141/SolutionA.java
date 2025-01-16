package org.nick.learn.leetcode.problem141;

import java.util.HashSet;
import java.util.Set;

public class SolutionA {

    public boolean hasCycle(ListNode head) {
        if(null == head){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        set.add(head);


        while((head = head.next) != null){
            boolean addS = set.add(head);
            if (!addS) {
                return true;
            }
        }

        return false;
    }
}