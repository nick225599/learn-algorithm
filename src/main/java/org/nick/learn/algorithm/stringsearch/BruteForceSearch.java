package org.nick.learn.algorithm.stringsearch;

import lombok.extern.slf4j.Slf4j;


/**
 *  sunchuansheng 20241225 BF算法都写不好，拉几把倒，继续看下去吧
 */
@Slf4j
public class BruteForceSearch {

    public static int searchStr(String mainStr, String patternStr) {
        int lengthOfMain = mainStr.length();
        int lengthOfPattern = patternStr.length();
        if (lengthOfMain < lengthOfPattern) {
            return -1;
        }


        int result = -1;
        for(int i = 0; i < lengthOfMain; i++){
            for(int tmpI=i, j = 0; tmpI < lengthOfMain && j < lengthOfPattern; j++){
                if(mainStr.charAt(tmpI) == patternStr.charAt(j)){
                    if(-1 == result){
                        result = i;
                    }
                    tmpI++;

                    // 如果要实现暴力搜索算法就要双循环查找
                }else{
                    result = -1;
                    break;
                }
            }
        }
//        return result;
         return mainStr.indexOf(patternStr);
    }

    public static void main(String[] args) {

    }
}
