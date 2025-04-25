package org.nick.learn.leetcode.p8;

import javax.naming.OperationNotSupportedException;

public class Solution2 {

    /**
     * 可以用 long 型来存储数据来规避 int 值过大 过小 无法转换需要抛异常的问题
     * 不过如果题目是将字符串转换成 Long 型，
     * 那当前这个解法一样无法避免转换过程数值越界问题
     */
    public int myAtoi(String s) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("未实现");
        // long result = 0;
        // 读入一个字符，转换成 int tmpI;
        // result = 10 * result + tmpI;
        // 跟 Integer.MAX_VAL MIN_VAL 判断是否越界
        //
        // 继续读入下一个字符，直至读完或者读入非数字
    }
}
