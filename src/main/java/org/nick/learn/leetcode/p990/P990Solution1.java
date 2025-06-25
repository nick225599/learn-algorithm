package org.nick.learn.leetcode.p990;

public class P990Solution1 {

    public boolean equationsPossible(String[] equations) {
        // 初始化
        int[] root = new int[26];
        for (int i = 0; i < 26; i++) {
            root[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                union(root, c1, c2);
            }
        }

        for(String equation : equations) {
            if(equation.charAt(1) == '!'){
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                if(find(root, c1) == find(root, c2)){
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] root, char c1, char c2) {
        int root1 = find(root, c1);
        int root2 = find(root, c2);
        if(root1 != root2){
            root[root2] = root1;
        }
    }

    private int find(int[] root, char c1) {
        int i = c1 - 'a';
        while (root[i] != i) {
            i = root[i];
        }
        return i;
    }
}
