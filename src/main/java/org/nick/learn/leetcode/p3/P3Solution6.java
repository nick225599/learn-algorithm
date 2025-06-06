package org.nick.learn.leetcode.p3;

public class P3Solution6 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[] occ = new boolean[128];
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < n; right++) {
            while (occ[chars[right]]) {
                occ[chars[left]] = false;
                left++;
            }
            occ[chars[right]] = true;

            // 只有当右边界扩到不能再扩为止才计算一次最大长度
            if(
                    (right + 1 < n && occ[chars[right + 1]])
                    || (right + 1 == n)
            ){
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }

//    class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            char[] str = s.toCharArray();
//            int n = str.length;
//            int ans = 0;
//            int left = 0;
//            int[] cnt = new int[128];
//            for(int right = 0; right < n; right++){
//                char c = str[right];
//                cnt[c]++;
//                while(cnt[c] > 1){
//                    cnt[str[left]]--;
//                    left++;
//                }
//                ans = Math.max(ans, right - left + 1);
//            }
//            return ans;
//        }
//    }

}
