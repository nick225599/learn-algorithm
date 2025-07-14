package org.nick.learn.leetcode.p77;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@Slf4j
public class P77Solution12 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (n < k) {
            return result;
        }

        boolean[] arr = new boolean[n];
        for (int i = 0; i < k; i++) {
            arr[i] = true;
        }
        System.out.println(Arrays.toString(arr));

        int r = 0;
        while (r++ < 10) {


            if (arr[0]) {
                // 规则一：x 的最低位为 1，这种情况下，如果末尾由 t 个连续的 1，
                // 我们直接将倒数第 t 位的 1 和倒数第 t+1 位的 0 替换，
                // 就可以得到 next(x)。
                // 如 0011→0101，0101→0110，1001→1010，1001111→1010111。
                int i = 0;
                while (arr[i]) {
                    i++;
                }
                arr[i] = true;
                arr[i - 1] = false;

                System.out.println(Arrays.toString(arr));

            } else {
                // 规则二：x 的最低位为 0，这种情况下，
                // 末尾有 t 个连续的 0，而这 t 个连续的 0 之前有 m 个连续的 1，
                // 我们可以将倒数第 t+m 位置的 1 和倒数第 t+m+1 位的 0 对换，
                // 然后把倒数第 t+1 位到倒数第 t+m−1 位的 1 移动到最低位。
                // 如 0110→1001，1010→1100，1011100→1100011。
                int t = 0; // 末尾有 t 个连续的 0
                int m = 0; // 而这 t 个连续的 0 之前有 m 个连续的 1
                for (int i = 0; i < arr.length; i++) {
                    if (!arr[i]) {
                        t++;
                    } else {
                        break;
                    }
                }
                for (int j = t; j < arr.length; j++) {
                    if (arr[j]) {
                        m++;
                    } else {
                        break;
                    }
                }
                if (t + m == arr.length) {
                    arr[t + m] = !arr[t + m];
                }
                if (t + m + 1 != arr.length) {
                    arr[t + m + 1] = !arr[t + m + 1];
                }
                for (int i = 0; i < t + m; i++) {
                    if (i < m - 1) {
                        arr[i] = true;
                    } else {
                        arr[i] = false;
                    }
                }

                System.out.println(Arrays.toString(arr));

            }
        }

        return null;

    }


}
