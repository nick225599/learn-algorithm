package org.nick.learn.leetcode.p117;

public class P117Solution4 {

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }

        Node head = root;
        while (head != null) {
            Node nextHead = null;
            Node pre = null;
            while (head != null) {
                if (head.left != null) {
                    if (nextHead == null) {
                        nextHead = head.left;
                    }
                    if (pre != null) {
                        pre.next = head.left;
                        pre = head.left;
                    } else {
                        pre = head.left;
                    }
                }

                if (head.right != null) {
                    if (nextHead == null) {
                        nextHead = head.right;
                    }
                    if (pre != null) {
                        pre.next = head.right;
                        pre = head.right;
                    } else {
                        pre = head.right;
                    }
                }

                head = head.next;
            }


            head = nextHead;
        }
        return root;


//        Node curLevelHead = root;    // 当前层的头元素
//        Node curLevelCurNode = null; // 当前层的遍历对象
//
//        Node nextLevelHead = null;    // 下一层的头对象
//        Node nextLevelPreNode = null; // 下一层的上一个遍历对象
//        Node nextLevelCurNode = null; // 下一层的当前遍历对象
//
//        while (curLevelHead != null) {
//            curLevelCurNode = curLevelHead;
//
//            // 找到下一层要处理的节点
//            while (nextLevelCurNode == null) {
//                while (curLevelCurNode != null) {
//                    if (curLevelCurNode.left != null && !curLevelCurNode.left.equals(nextLevelPreNode)) {
//                        nextLevelCurNode = curLevelCurNode.left;
//                        break;
//                    }
//
//                    if (curLevelCurNode.right != null) {
//                        nextLevelCurNode = curLevelCurNode.right;
//
//                        // curLevelCurNode 左右节点都处理完了，将 curLevelCurNode 更新到下一个
//                        curLevelCurNode = curLevelCurNode.next;
//
//                        break;
//                    }else{
//                        // curLevelCurNode 左右节点都处理完了，将 curLevelCurNode 更新到下一个
//                        curLevelCurNode = curLevelCurNode.next;
//                    }
//
//                    // 这段干啥用的？？？
////                    if (nextLevelCurNode != null) {
////                        curLevelCurNode = curLevelCurNode.next;
////                        break;
////                    }
//
//                }
//                if (null == nextLevelHead) {
//                    nextLevelHead = nextLevelCurNode;
//                }
//                if (null != nextLevelPreNode) {
//                    nextLevelPreNode.next = nextLevelCurNode;
//                }
//                nextLevelPreNode = nextLevelCurNode;
//                nextLevelCurNode = null;
//
//                if (nextLevelPreNode == null) {
//                    break;
//                }
//            }
//
//            curLevelHead = nextLevelHead;
//            nextLevelHead = null;
//        }
//
//        return root;
    }


}
