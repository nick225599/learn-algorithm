package org.nick.learn.leetcode.p71;

public class P71Solution4 {

    // 用数组模拟 Deque 和 StringBuilder，牺牲了可读性换取进一步的性能提升
    public String simplifyPath(String path) {
        path += "/";
        char[] stack = new char[path.length()];
        int pos = -1;
        char[] arr = path.toCharArray();
        for (char c : arr) {
            if (pos == -1) {
                stack[++pos] = c;
            } else {
                if (c == '/') {
                    if (stack[pos] == '/') {
                        pos--;
                    } else if (stack[pos] == '.') {
                        int dot_cnt = 0;
                        int t_pos = pos;
                        while (t_pos >= 0 && stack[t_pos] != '/') {
                            if (stack[t_pos] == '.') {
                                dot_cnt++;
                            } else {
                                dot_cnt = 0;
                                break;
                            }
                            t_pos--;
                        }
                        if (dot_cnt > 0 && dot_cnt <= 2) {
                            int level = dot_cnt / 2 + 1;
                            while (pos >= 0 && level > 0) {
                                if (stack[pos--] == '/') {
                                    level--;
                                }
                            }
                        }

                    }
                    stack[++pos] = c;
                } else {
                    stack[++pos] = c;
                }
            }
        }
        if (pos > 1 && stack[pos] == '/') {
            pos--;
        }
        return new String(stack, 0, pos + 1);
    }

}
