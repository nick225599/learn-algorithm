package org.nick.learn.leetcode.p373;

import java.util.ArrayList;
import java.util.List;

public class P373Solution2 {

    int[] nums1, nums2;
    int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
    boolean preIsLeft = true, preIsRight = true;
    int n1;
    int n2;
    List<List<Integer>> ans;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        this.n1 = nums1.length;
        this.n2 = nums2.length;
        this.ans = new ArrayList<>(k);
        this.nums1 = nums1;
        this.nums2 = nums2;

        List<Integer> pair = new ArrayList<>(2);
        pair.add(nums1[0]);
        pair.add(nums2[0]);
        ans.add(pair);

        k--;
        while (k > 0) {
            Integer num1 = this.getNextNumLeftFixed();
            Integer num2 = this.getNextNumRightFixed();
            boolean useLeft = this.useLeft(num1, num2);
            if (useLeft) {
                pair = new ArrayList<>(2);
                pair.add(nums1[l1]);
                pair.add(nums2[l2]);
                preIsLeft = true;
                preIsRight = false;
            } else {
                pair = new ArrayList<>(2);
                pair.add(nums1[r1]);
                pair.add(nums2[r2]);
                preIsLeft = false;
                preIsRight = true;
            }
            ans.add(pair);
            k--;
        }
        return ans;
    }


    private Integer getNextNumLeftFixed() {
        if (preIsLeft) {
            if (l1 < n1) {
                l2++;
                if (l2 == n2) {
                    l1++;
                    l2 = 0;
                    if (l1 == n1) {
                        return null;
                    }
                }
                return nums1[l1] + nums2[l2];
            }
            return null;
        } else {
            return nums1[l1] + nums2[l2];
        }
    }

    private Integer getNextNumRightFixed() {
        if (preIsRight) {
            if (r2 < n2) {
                r1++;
                if (r1 == n1) {
                    r1 = 0;
                    r2++;
                    if (r2 == n2) {
                        return null;
                    }
                }
                return nums1[r1] + nums2[r2];
            }
            return null;
        } else {
            return nums1[r1] + nums2[r2];
        }
    }

    private boolean useLeft(Integer num1, Integer num2) {
        if (num1 == null) {
            return false;
        }
        if (num2 == null) {
            return true;
        }
        return num1 < num2;
    }


}
