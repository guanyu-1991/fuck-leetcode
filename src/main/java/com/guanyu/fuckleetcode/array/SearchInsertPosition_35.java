package com.guanyu.fuckleetcode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * see {@linktourl https://leetcode.cn/problems/search-insert-position/}
 *
 * 采用二分搜索的思想，跟二分查找稍微不同的是，在二分查找中，如果没有找到target,直接返回负一；当前题目中，如果没有找到target值，则直接返回mid的最后一个值,来确定
 * 要返回的值；
 * 如果 target > nums[mid],则说明要在mid处插入，返回mid + 1
 * 如果 target < nums[mid],则说明就在mid处插入（原来mid位置的元素后移一位），则返回mid
 *
 * @author zhanglu01
 * @date 2023-03-08 10:07 AM
 **/
public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right =  nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        //处理最后的返回值
        if (nums[mid] < target) {
            return mid + 1;
        }
        return mid;
    }
}
