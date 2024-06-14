package org.nick.learn.algorithm.aaa_binary_search;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nick.learn.algorithm.search.aaa_binary_search.BinarySearchUtils;

public class BinarySearchUtilsTest {

    int[] nums = new int[]{-1, 0, 3, 5, 9, 12, 15};

    int target1 = 9;
    int result1 = 4;

    int target2 = 2;
    int result2 = -1;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void binarySearchLeftIncludeRightInclude() {
        Assert.assertEquals(result1, BinarySearchUtils.binarySearchLeftIncludeRightInclude(nums, target1));
        Assert.assertEquals(result2, BinarySearchUtils.binarySearchLeftIncludeRightInclude(nums, target2));
    }

    @Test
    public void binarySearchLeftIncludeRightExclude() {
        Assert.assertEquals(result1, BinarySearchUtils.binarySearchLeftIncludeRightExclude(nums, target1));
        Assert.assertEquals(result2, BinarySearchUtils.binarySearchLeftIncludeRightExclude(nums, target2));
    }

    @Test
    public void binarySearchLeftExcludeRightInclude() {
        Assert.assertEquals(result1, BinarySearchUtils.binarySearchLeftExcludeRightInclude(nums, target1));
        Assert.assertEquals(result2, BinarySearchUtils.binarySearchLeftExcludeRightInclude(nums, target2));
    }

    @Test
    public void binarySearchLeftExcludeRightExclude() {
        Assert.assertEquals(result1, BinarySearchUtils.binarySearchLeftExcludeRightExclude(nums, target1));
        Assert.assertEquals(result2, BinarySearchUtils.binarySearchLeftExcludeRightExclude(nums, target2));
    }
}