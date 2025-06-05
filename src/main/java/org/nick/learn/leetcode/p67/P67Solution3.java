package org.nick.learn.leetcode.p67;

public class P67Solution3 {
    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            carry += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.append(carry % 2 == 0 ? "0" : "1");
            carry >>= 1;
        }
        if(carry != 0){
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/add-binary/solutions/299667/er-jin-zhi-qiu-he-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
