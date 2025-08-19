package org.nick.learn.leetcode.p137;

import org.apache.commons.lang3.StringUtils;

//@Slf4j
public class P137Solution2 {

    // You must implement a solution with a linear runtime complexity and use only constant extra space.
    // 线性 常数空间，那只能求和

    // 不，傻瓜，还能按位求和
    // 没写对

    // 4ms 击败 25.67 %
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : nums) {
                // num 第 i 位是 0 还是 1 ？
                int bitNum = ((num >> i) & 1) == 1 ? 1 : 0;
                bitSum += bitNum;

//                log.info("num: {}, 二进制格式: {}, 第 {} 位的值为 {}, 第 {} 位的累加结果: {}",
//                        num, this.intToBinaryStr(num), i, bitNum, i, bitSum );
            }
            // ans 第 i 位的值
            int bitVal = bitSum % 3;
//            log.info("第 {} 位的累加结果: {},  ans 的第 {} 位为: {}",
//                    i, bitSum, i, bitVal);
            // 组装 ans
            if (bitVal == 1) {
                ans += 1 << i;
            }
//            log.info("第 {} 位的计算结束后，ans 为：{}", i, ans);
        }
        return ans;
    }

    private String intToBinaryStr(int num) {
        String str = StringUtils.leftPad(Integer.toBinaryString(num), 32, '0');
        String sb = str.substring(0, 8) + "_" +
                str.substring(9, 16) + "_" +
                str.substring(17, 24) + "_" +
                str.substring(25, 32);
        return "0b" + sb;

    }



}
