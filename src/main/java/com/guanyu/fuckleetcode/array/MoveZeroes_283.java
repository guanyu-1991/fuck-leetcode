package com.guanyu.fuckleetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 连接:https://leetcode.cn/problems/move-zeroes/
 *
 *
 * @author zhanglu01
 * @date 2023-03-20 3:50 PM
 **/
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) {
            return;
        }
        int s = 0; //指向第一个不为0的元素
        int f = 0; //用来遍历整个数组
        while(f < nums.length) {
            if(nums[f] != 0) {
                nums[s] = nums[f];
                if (s != f) {
                    nums[f] = 0;
                }
                s++;

            }
            f++;
        }
    }
}
