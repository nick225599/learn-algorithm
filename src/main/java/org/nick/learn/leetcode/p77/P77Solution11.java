package org.nick.learn.leetcode.p77;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.nick.learn.algorithm.utils.ArrayUtils.swap;


@Slf4j
public class P77Solution11 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (n < k) {
            return result;
        }

        int[] arr = new int[k];
        for (int i = 1; i <= k; i++) {
            arr[i - 1] = i;
        }
        result.add(Arrays.stream(arr).boxed().toList());
        if (n == k) {
            return result;
        }


        if (arr[0] == 1) {
            // 规则一：x 的最低位为 1，这种情况下，
            // 如果末尾由 t 个连续的 1，我们直接将倒数第 t 位的 1 和倒数第 t+1 位的 0 替换，就可以得到 next(x)。
            // 如 0011→0101，0101→0110，1001→1010，1001111→1010111。
            int i;
            for ( i = 0; i < arr.length && arr[i] == i + 1; i++) {

            }
            swap(arr, i, i - 1);
        } else {
            // 规则二：x 的最低位为 0，这种情况下，
            // 末尾有 t 个连续的 0，而这 t 个连续的 0 之前有 m 个连续的 1，
            // 我们可以将倒数第 t+m 位置的 1 和倒数第 t+m+1 位的 0 对换，
            // 然后把倒数第 t+1 位到倒数第 t+m−1 位的 1 移动到最低位。
            // 如 0110→1001，1010→1100，1011100→1100011。
            int i = 0;
            // 怎么判断 arr[i] 是 0 ？
            while(arr[0] != i+1){
                i++;
            }
            // 此时 arr[0] = i + 1;
            for(int t = 1; t < arr.length && arr[t] == arr[t - 1] + 1; t++){
            }
            // 此时 arr[t] != arr[t - 1]
            //TODO nick 20250714 放弃，先去看看官方题解咋写的

            // 1011100→1100011



        }


        return null;

    }


}
