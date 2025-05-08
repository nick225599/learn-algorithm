package org.nick.learn.leetcode.p380;

import java.util.*;

/**
 * 力扣 380. O(1) 时间插入、删除和获取随机元素
 *
 * @see <a href="https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150">力扣 380. O(1) 时间插入、删除和获取随机元素</a>
 */
public class P380Solution2 {
    class RandomizedSet {
        private List<Integer> nums;
        private Map<Integer, Integer> indices; // 不能换用 hashSet 因为要存下标 用来快速删除 和随机访问
        private Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            indices = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            nums.add(val);
            indices.put(val, nums.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }

            int index = indices.get(val);
            int lastVal = nums.getLast();
            nums.set(index, lastVal);
            indices.put(lastVal, index);
            nums.removeLast();
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
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
