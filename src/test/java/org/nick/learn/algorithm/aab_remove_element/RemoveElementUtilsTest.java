package org.nick.learn.algorithm.aab_remove_element;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveElementUtilsTest {

    int[] nums1 = new int[]{3, 2, 2, 3};
    int val1 = 3;
    int[] nums2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    int val2 = 2;

//    输入：nums = [3,2,2,3], val = 3
//    输出：2, nums = [2,2]
//    解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
//    示例 2：
//
//    输入：nums = [0,1,2,2,3,0,4,2], val = 2
//    输出：5, nums = [0,1,4,0,3]

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void removeElement() {
        Assert.assertEquals(2, RemoveElementUtils.removeElement(nums1, val1));
        Assert.assertArrayEquals(new int[]{2, 2}, nums1);

        Assert.assertEquals(5, RemoveElementUtils.removeElement(nums2, val2));
        Assert.assertArrayEquals(new int[]{0, 1, 4, 0, 3}, nums2);
    }
}