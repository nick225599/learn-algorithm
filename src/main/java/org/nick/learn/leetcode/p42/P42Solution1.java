package org.nick.learn.leetcode.p42;

public class P42Solution1 {

    // 首先判断自己在上升区间还是在下降区间
    // 如果在上升区间，那么在前面那个下降区间从后往前找不大于自己的最大值
    // 如果在下降区间，那么要记录下降区间的开始位置和结束位置

    // 太搞了，有没有简单点的思路？
    public int trap(int[] height) {
        int n = height.length;
        int descStart = -1;
        int descEnd = -1;
        int total = 0;
        for (int i = 1; i < n; i++) {
            int preH = height[i - 1];
            int curH = height[i];
            int nextH = -1;
            if(i + 1 < n){
                nextH = height[i + 1];
            }
            if (preH <= curH && (nextH == -1 || nextH < curH)) {
                if (descStart != -1) {
                    int block = 0;
                    int preDescH = 0;
                    for (int j = descEnd; j >= descStart; j--) {
                        int curDescH = height[j];
                        block += (curDescH - preDescH) * (i - j - 1);
                        preDescH = curDescH;
                    }
                    total += block;
                    descStart = descEnd = i;
                }
            } else {
                if (descStart == -1) {
                    descStart = i - 1;
                }
                descEnd = i;
            }


        }
        return total;
    }
}
