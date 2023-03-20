package com.guanyu.fuckleetcode.array;

/**
 * 26. 删除有序数组中的重复项
 * leetcode连接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 *
 * 双指针解法：
 * 由于数组是有序数组，所以如果有重复元素，那么重复元素在数组中必然是连续的
 * 我们可以将数组分为两部分，前半部分是已经去掉重复元素的数组，慢指针永远指向前半部分数组的最后一个元素
 * 快指针则用来遍历
 *
 * @author zhanglu01
 * @date 2023-03-14 9:57 AM
 **/
public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int s = 0; //慢指针
        int f = 1; //快指针
        while (f < nums.length) {
            if (nums[s] != nums[f]) {
                nums[++s] = nums[f];
            }
            f++;
        }
        return s + 1;
    }
}
