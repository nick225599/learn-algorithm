package org.nick.learn.leetcode.p45;

/**
 * 力扣 45. 跳跃游戏 II
 * @see <a href="https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150">力扣 45. 跳跃游戏 II</a>
 */
public class P45Solution2 {
    /**
     * 看懂了，再来一次
     */
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int times = 0;
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            r = Math.max(r, nums[i] + i);
            if (i == l) {
                System.out.println("从上一个区间（或起始位置）跳入到 [" + l + ", " + r + "] 区间内得跳一次，最远跳到 " + r);
                times++;
                l = r;

                if (r >= nums.length - 1) {
                    return times;
                }
            }
        }
        throw new IllegalStateException();
    }

}
