package org.nick.learn.leetcode.p172;

public class P172Solution2 {

    // 我们知道，只有2∗5才可以得到一个0，那我们只需要看7!可以分解为多少个2∗5就可以。
    //
    //2出现的频率肯定是高于5的，因为:
    //
    //每隔 2 个数就会包含因子2，比如2,4,6,..，
    //而每个 5 个数才会出现一个包含因子5的数，比如5,10,15,..
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }

        int count = 0;
        for (int i = n; i >= 1; i--) {
            if (i % 5 == 0) {
                for (int j = i; j >= 5 && j % 5==0; j /= 5) {
                    count++;
                }
            }
        }
        return count;
    }
}
