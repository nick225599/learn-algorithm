package org.nick.learn.leetcode.p10;

public class Solution1 {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;

        char preS = '~';
        char preP = '~';

        char curS = '~';
        char curP = '~';

        char nextS = '~';
        char nextP = '~';

        while (i < s.length() || j < p.length()) {
            if (i - 1 >= 0) {
                preS = p.charAt(i - 1);
            } else {
                preS = '~';
            }
            if (j - 1 >= 0) {
                preP = p.charAt(j - 1);
            } else {
                preP = '~';
            }

            if (i < s.length()) {
                curS = s.charAt(i);
            } else {
                curS = '~';
            }
            if (j < p.length()) {
                curP = p.charAt(j);
            } else {
                curP = '~';
            }

            if (i + 1 < s.length()) {
                nextS = s.charAt(i + 1);
            } else {
                nextS = '~';
            }
            if (j + 1 < p.length()) {
                nextP = p.charAt(j + 1);
            } else {
                nextP = '~';
            }


            if (curS == curP) {
                i++;
                j++;
            } else if (curP == '.') {
                i++;
                j++;
            } else if (curP == '*' && preP == curS) {
                i++;
            } else if (curP == '*' && preP == '.') {
                i++;
                j++;
            } else if (curP == '*' && curS == '~') {
                j++;
            } else if(curP == '*' && nextP != '~'){
                j++;
            } else if (nextP == '*') {
                j++;
            } else {
                break;
            }
        }
        if (i == s.length() && j == p.length()) {
            return true;
        }
        return false;
    }


}
