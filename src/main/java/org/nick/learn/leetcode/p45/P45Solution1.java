package org.nick.learn.leetcode.p45;

/**
 * 力扣 45. 跳跃游戏 II
 * @see <a href="https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150">力扣 45. 跳跃游戏 II</a>
 */
public class P45Solution1 {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return 1;
        }

        int rightEnd = 0;
        int times = 0;
        for (int i = 0; i < n; ) {
            for (int j = 1; j < nums[i]; j++) {
                int tmpI = i + j;
                if (tmpI >= n) {
                    return times;
                }
                int tmpRightEnd = tmpI + nums[tmpI];
                if (tmpRightEnd > rightEnd) {
                    rightEnd = tmpRightEnd;
                }
            }
            i = rightEnd;
            rightEnd = 0;
            times += 2;

        }
        return times;
    }

}
