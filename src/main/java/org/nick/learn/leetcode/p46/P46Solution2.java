package org.nick.learn.leetcode.p46;

import java.util.*;

public class P46Solution2 {

    // 朴素解法，优化版，不存整个字符串作为 key 而是算它的 hash 值
    // 不用排序了，也能一定程度优化内存
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
//            String key = hash(str);
            int key = hash2(str);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

    private String hash(String str){
        int[] arr = new int[26];
        for(char c : str.toCharArray()){
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){

            // 能让 key 进一步变短
            if (arr[i] != 0) {
                sb.append((char) ('a' + i));
                sb.append(arr[i]);
            }

//            作者：力扣官方题解
//            链接：https://leetcode.cn/problems/group-anagrams/solutions/520469/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/
//            来源：力扣（LeetCode）
//            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//            sb.append(arr[i]).append(",");
        }
        return sb.toString();
    }


    //nick 这个 hash 函数是真看不懂了
    public int hash2(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sum += (ch * ch * ch * (ch - 1)  - ch);
        }
        return sum;
    }
}
