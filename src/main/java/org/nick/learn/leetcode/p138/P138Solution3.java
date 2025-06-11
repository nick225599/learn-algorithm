package org.nick.learn.leetcode.p138;

public class P138Solution3 {

    // 不通用，但在此题是个非常巧妙的处理计较，将空间复杂度降低到 O(1)
    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        // 将
        //     n -> n.next -> ...
        // 改造成
        //     n -> newN -> n.next -> ...
        for (Node n = head; n != null; n = n.next.next) {
            Node newN = new Node(n.val);
            newN.next = n.next;
            n.next = newN;
        }

        // 此时刚好 random.next = newRandom，所以就可以......
        for (Node n = head; n != null; n = n.next.next) {
            if (null == n.random) {
                continue;
            }
            n.next.random = n.random.next;
        }

        // 最后将一个 Node 一分为二
        Node newHead = head.next;
        for (Node node = head; null != node; node = node.next) {
            Node newNode = node.next;
            Node nextOfNode = newNode.next;
            if(null == nextOfNode){
                node.next = null;
                newNode.next = null;
            }else{
                Node nextOfNewNode = nextOfNode.next;
                node.next = nextOfNode;
                newNode.next = nextOfNewNode;
            }
        }
        return newHead;

    }


}
