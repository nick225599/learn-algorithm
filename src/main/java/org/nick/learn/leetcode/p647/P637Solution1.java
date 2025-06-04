package org.nick.learn.leetcode.p647;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P637Solution1 {

    // 广度优先
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            queue = averageOfCurrentLevel(queue, avg);
        }

        return avg;
    }

    private Queue<TreeNode> averageOfCurrentLevel(Queue<TreeNode> queue, List<Double> avg) {
        double sum = 0;
        double count = 0;
        Queue<TreeNode> nextLevel = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null == node) {
                continue;
            }
            sum += node.val;
            count++;

            if (null != node.left) {
                nextLevel.add(node.left);
            }
            if (null != node.right) {
                nextLevel.add(node.right);
            }
        }
        avg.add(sum/count);
        return nextLevel;
    }
}
