package org.nick.learn.leetcode.p909;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P909Solution2 {

    static class MoveStatus {
        public int cur;
        public int steps;

        public MoveStatus(int cur, int steps) {
            this.cur = cur;
            this.steps = steps;
        }
    }

    // 让 AI 优化一下
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int total = n * n;

        Queue<MoveStatus> queue = new LinkedList<>();
        queue.offer(new MoveStatus(1, 0));

        int minSteps = Integer.MAX_VALUE;
        boolean[] visited = new boolean[total + 1];
        while (!queue.isEmpty()) {
            MoveStatus cur = queue.poll();
            visited[cur.cur] = true;
            if (cur.cur == total) {
                minSteps = Math.min(minSteps, cur.steps);
            } else {
                for(int i = 1; i <= 6; i++){
                    int next = cur.cur + i;
                    if(next > total){
                        break;
                    }
                    int[] arr = index2coordinate(n, next);
                    int x = arr[0];
                    int y = arr[1];
                    if(board[x][y] != -1){
                        next = board[x][y];
                    }
                    if(!visited[next]){
                        queue.add(new MoveStatus(next, cur.steps + 1));
                    }
                }
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;


    }

    private int[] index2coordinate(int widthOfBoard, int index) {
        index--;

        int a, b; // index = n * a + b
        a = index / widthOfBoard;
        b = index - a * widthOfBoard;

        int row, column;
        row = widthOfBoard - 1 - a;
        if ((widthOfBoard - 1 - row) % 2 == 0) {
            column = b;
        } else {
            column = widthOfBoard - 1 - b;
        }
        return new int[]{row, column};
    }




}
