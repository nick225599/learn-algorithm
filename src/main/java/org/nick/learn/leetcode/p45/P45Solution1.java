package org.nick.learn.leetcode.p45;

/**
 * 力扣 45. 跳跃游戏 II
 * @see <a href="https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150">力扣 45. 跳跃游戏 II</a>
 */
public class P45Solution1 {
        public int jump(int[] nums) {
            int length = nums.length;
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < length - 1; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/jump-game-ii/solutions/230241/tiao-yue-you-xi-ii-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
