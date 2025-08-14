package org.nick.learn.leetcode.p137;

public class P137Solution2 {

    // You must implement a solution with a linear runtime complexity and use only constant extra space.
    // 线性 常数空间，那只能求和

    // 不，傻瓜，还能按位求和
    // 没写对
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : nums) {
                // num 第 i 位是 0 还是 1 ？
                int bitNum = ((1 << i) & num) == 1 ? 1 : 0;
                bitSum += bitNum;
            }
            // ans 第 i 位的值
            int bitVal = bitSum % 3;
            System.out.println("第 " + i + " 位的值：" + bitVal);

            // 组装 ans
            if (bitVal == 1) {
                ans += 1 << i;
            }
        }
        return ans;
    }
}
