package org.nick.learn.leetcode.p172;

public class P172Solution4 {

    // n/5 = 25/5 = 5 → 这一步算的是 “有多少个含至少 1 个 5 的数”（5、10、15、20、25），对应每个数先算 1 个 5，共 5 个 5；
    // n/25 = 25/25 = 1 → 这一步算的是 “有多少个含至少 2 个 5 的数”（只有 25），这些数在第一步已经算过 1 个 5 了，现在需要补算 “多出来的 1 个 5”，共 1 个 5；

    // O(logn)
    public int trailingZeroes(int n) {
        int count = 0;
        int i = 5;
        while(i < n){
            count += (n / i);
            i*=5;
        }
        return count;
    }
}
