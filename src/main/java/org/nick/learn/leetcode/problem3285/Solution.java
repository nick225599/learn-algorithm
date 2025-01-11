package org.nick.learn.leetcode.problem3285;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 最直观的方案
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>(height.length);
        for (int i = 0; i < height.length - 1;) {
            if (height[i] > threshold) {
                result.add(++i);
            }else{
                i++;
            }
        }
        return result;
    }

}