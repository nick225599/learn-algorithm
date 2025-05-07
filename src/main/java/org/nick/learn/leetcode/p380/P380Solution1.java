package org.nick.learn.leetcode.p380;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 力扣 380. O(1) 时间插入、删除和获取随机元素
 *
 * @see <a href="https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150">力扣 380. O(1) 时间插入、删除和获取随机元素</a>
 */
public class P380Solution1 {


    class RandomizedSet {
        private final Set<Integer> hashTable = new HashSet<>();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            return hashTable.add(val);
        }

        public boolean remove(int val) {
            return hashTable.remove(val);
        }

        public int getRandom() {
            Random r = new Random();
            int targetIdx = r.nextInt(hashTable.size());
            Iterator<Integer> iterator = hashTable.iterator();
            int i = 0;
            while(i < targetIdx){
                iterator.next();
                i++;
            }
            return iterator.next();
        }
    }

}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
