package com.guanyu.fuckleetcode.array;

/**
 * 在排序数组中查找元素的第一个和最后一个位置(34题)
 * see {@linktourl https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/}
 *
 * 解法1：双指针遍历，左边指针从数组头开始遍历，遇到target则停止；右指针从数组尾部开始遍历，遇到target停止遍历；返回左右指针即可（不过不符合题目O(lgN)复杂度的要求）
 *
 * 解法2：二分查找 + 双指针结合
 * 利用二分查找先找到一个跟target值相等的元素，然后以这个元素位置为基准，利用双指针分别向数组两边遍历，双指针遇到第一个不为target的原则就停止；然后返回双指针上/下一个元素位置
 *
 * 解法3：二分法 + 各个击破，写两个函数，分别求出最左边值为target元素的下标以及最右边值为target元素的下标
 * @author zhanglu01
 * @date 2023-03-08 11:12 AM
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * 解法2
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange_2(int[] nums, int target) {
        //1. 通过二分查找，找到其中一个等于target的元素下标
        int flag = binarySearch(nums, target);
        if (flag == -1) {
            return new int[] {-1, -1};
        }

        //2. 双指针寻找左右两边等于target的首元素下标
        int l = flag;
        int r = flag;
        while (l >= 0 || r < nums.length) { //确定循环不变条件：双指针都没有走到头
            if (l >= 0 && nums[l] == target) l--;
            if (r < nums.length && nums[r] == target) r++;
            //确定跳出循环的条件：左右指针都已经走到头，或者遇到值不等于target的元素
            if ((l < 0 || nums[l] != target) && (r >= nums.length || nums[r] != target)) {
                break;
            }
        }
        return new int[] {l + 1, r - 1};
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 解法3
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange_3(int[] nums, int target) {
        int l = findLeft(nums, target);
        if (l == -1) {
            return new int[] {-1, -1};
        }
        int r = findRight(nums, target);
        return new int[] {l, r};
    }

    private int findLeft(int[] nums, int target) {
        int l = binarySearch(nums, target);
        if (l == -1) {
            return -1;
        }
        while (l > 0) {
            if (nums[l - 1] == target) {
                l --;
                continue;
            }
            return l;
        }
        return 0;
    }

    private int findRight(int[] nums, int target) {
        int r = binarySearch(nums, target);
        if (r == -1) {
            return -1;
        }
        while (r < nums.length - 1) {
            if (nums[r + 1] == target) {
                r ++;
                continue;
            }
            return r;
        }
        return nums.length - 1;
    }

}
