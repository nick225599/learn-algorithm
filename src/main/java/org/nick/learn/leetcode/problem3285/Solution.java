package org.nick.learn.leetcode.problem3285;

import org.junit.Assert;

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


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] mountains;
        List<Integer> indicesOfStableMountains;

        mountains = new int[]{1, 2, 3, 4, 5};
        indicesOfStableMountains = solution.stableMountains(mountains, 2);
        Assert.assertEquals(2, indicesOfStableMountains.size());
        Assert.assertTrue(indicesOfStableMountains.contains(3));
        Assert.assertTrue(indicesOfStableMountains.contains(4));

        mountains = new int[]{10, 1, 10, 1, 10};
        indicesOfStableMountains = solution.stableMountains(mountains, 3);
        Assert.assertEquals(2, indicesOfStableMountains.size());
        Assert.assertTrue(indicesOfStableMountains.contains(1));
        Assert.assertTrue(indicesOfStableMountains.contains(3));

        indicesOfStableMountains = solution.stableMountains(mountains, 10);
        Assert.assertEquals(0, indicesOfStableMountains.size());
    }
}