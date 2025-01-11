package org.nick.learn.algorithm.aaa_binary_search;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.search.aaa_binary_search.BinarySearchUtils;

public class BinarySearchUtilsTest {

    int[] nums = new int[]{-1, 0, 3, 5, 9, 12, 15};

    int target1 = 9;
    int result1 = 4;

    int target2 = 2;
    int result2 = -1;



    @Test
    public void binarySearchLeftIncludeRightInclude() {
        org.junit.jupiter.api.Assertions.assertEquals(result1, BinarySearchUtils.binarySearchLeftIncludeRightInclude(nums, target1));
        org.junit.jupiter.api.Assertions.assertEquals(result2, BinarySearchUtils.binarySearchLeftIncludeRightInclude(nums, target2));
    }

    @Test
    public void binarySearchLeftIncludeRightExclude() {
        org.junit.jupiter.api.Assertions.assertEquals(result1, BinarySearchUtils.binarySearchLeftIncludeRightExclude(nums, target1));
        org.junit.jupiter.api.Assertions.assertEquals(result2, BinarySearchUtils.binarySearchLeftIncludeRightExclude(nums, target2));
    }

    @Test
    public void binarySearchLeftExcludeRightInclude() {
        org.junit.jupiter.api.Assertions.assertEquals(result1, BinarySearchUtils.binarySearchLeftExcludeRightInclude(nums, target1));
        org.junit.jupiter.api.Assertions.assertEquals(result2, BinarySearchUtils.binarySearchLeftExcludeRightInclude(nums, target2));
    }

    @Test
    public void binarySearchLeftExcludeRightExclude() {
        org.junit.jupiter.api.Assertions.assertEquals(result1, BinarySearchUtils.binarySearchLeftExcludeRightExclude(nums, target1));
        org.junit.jupiter.api.Assertions.assertEquals(result2, BinarySearchUtils.binarySearchLeftExcludeRightExclude(nums, target2));
    }
}