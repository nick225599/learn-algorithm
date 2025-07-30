package org.nick.learn.leetcode.p373;

import java.util.ArrayList;
import java.util.List;

public class P373Solution2 {

    // 思路是对的，但是代码没写对
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        boolean leftUsed = true, rightUsed = true;
        List<List<Integer>> ans = new ArrayList<>(k);

        List<Integer> pair = new ArrayList<>(2);
        pair.add(nums1[l1]);
        pair.add(nums2[l2]);
        ans.add(pair);
        k--;

        //l1-> -10	0	3
        //		-4	1	5
        //		0	2	6
        //		0	3	7
        //		6	4	8	<-l2
        //			5	100

        // TODO nick 以左为轴，下一个要判断的对不应该是 (-10, 100)，而应该是 (-4, 3)
        //   回家总结一下这个选择的逻辑，然后转成代码

        while (k > 0) {
            int resultSize = ans.size();
            if (leftUsed) {
                int[] arr = this.moveToNext(n1, n2, l1, l2, r1, r2, true);
                l1 = arr[0];
                l2 = arr[1];
            }
            if (rightUsed) {
                int[] arr = this.moveToNext(n1, n2, l1, l2, r1, r2, false);
                r1 = arr[0];
                r2 = arr[1];
            }
            if (l1 == -1 && l2 == -1 && r1 == -1 && r2 == -1) {
                throw new IllegalStateException();
            } else if ((r1 == -1 && r2 == -1)
                    || (l1 != -1 && l2 != -1 && nums1[l1] + nums2[l2] < nums1[r1] + nums2[r2])) {
                // 使用左轴固定值
                pair = new ArrayList<>(2);
                pair.add(nums1[l1]);
                pair.add(nums2[l2]);
                ans.add(pair);
                k--;
                leftUsed = true;
                rightUsed = false;
            } else if ((l1 == -1 && l2 == -1)
                    || ((r1 != -1 && r2 != -1) && nums1[l1] + nums2[l2] > nums1[r1] + nums2[r2])) {
                // 使用右轴固定值
                pair = new ArrayList<>(2);
                pair.add(nums1[r1]);
                pair.add(nums2[r2]);
                ans.add(pair);
                k--;
                leftUsed = false;
                rightUsed = true;
            } else {
                // 同时使用左右轴值
                pair = new ArrayList<>(2);
                pair.add(nums1[l1]);
                pair.add(nums2[l2]);
                ans.add(pair);
                pair = new ArrayList<>(2);
                pair.add(nums1[r1]);
                pair.add(nums2[r2]);
                ans.add(pair);
                k -= 2;
                leftUsed = true;
                rightUsed = true;
            }
        }
        return ans;
    }

    private int[] moveToNext(int n1, int n2, int l1, int l2, int r1, int r2, boolean isLeft) {
        if (isLeft) {
            if (l1 != -1) {
                do {
                    l2++;
                    if (l2 == n2) {
                        l1++;
                        l2 = 0;
                        if (l1 == n1) {
                            l1 = l2 = -1;
                            break;
                        }
                    }
                } while (l1 <= r1 && l2 <= r2);
            }
            return new int[]{l1, l2};
        } else {
            if (r2 != -1) {
                do {
                    r1++;
                    if (r1 == n1) {
                        r1 = 0;
                        r2++;
                        if (r2 == n2) {
                            r1 = r2 = -1;
                            break;
                        }
                    }
                } while (r1 <= l1 && r2 <= l2);
            }
            return new int[]{r1, r2};
        }
    }


}
