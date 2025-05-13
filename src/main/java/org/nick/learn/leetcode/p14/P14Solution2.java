package org.nick.learn.leetcode.p14;

public class P14Solution2 {
    /**
     * 二分查找
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        // 计算最小长度
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int start = 0;
        int mid;
        int end = minLength - 1;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            boolean same = this.isCommonPrefix(strs, mid);
            if (same) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return strs[0].substring(0, start);
    }

    private boolean isCommonPrefix(String[] strs, int mid) {
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j <= mid; j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }


}
