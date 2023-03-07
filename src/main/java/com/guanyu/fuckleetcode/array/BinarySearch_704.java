package com.guanyu.fuckleetcode.array;

/**
 * @author zhanglu01
 * @date 2023-03-03 11:38 AM
 *
 * 二分查找
 * see {@linktourl https://leetcode.cn/problems/binary-search/}
 *
 * 二分查找的主要难点其实是边界的处理；目前不管是二分查找，还是其他的数组遍历，我们一般有两种处理方式：
 * 1. 左闭右开
 * 2. 左闭右闭
 * 很多时候我们对区间的开闭不好控制，也不好理解。首先我们要明确：空间的开闭都是针对数组遍历，使用双指针方法的场景；此时我们需要两个指针一个指向数组头，一个指向数组尾部。
 * 空间的开闭其实就是指首位两个指针的取值问题。
 * 二分查找的问题其实可以归纳为以下三个问题：
 * 1. 左右指针的初始化取值问题
 * 2. 循环条件的开闭问题
 * 3. 左右指针每次更新后的取值问题
 *
 * 左闭右闭解法三个问题：
 * 1. 左右指针的取值，都必须是合法的数组下标值（这也是为什么左右都是闭区间）；所以一般初始化的时候left = 0; right = arr.lenth - 1;
 * 2. 循环的不变条件也是while (left <= right),因为两个指针都是合法的数组下标值，所以他们是可能相遇的（用<=）
 * 3. 由于left和right都是合法下标值，所以每次中位数mid一定也是任何合法的下标值（包括边界值0和length - 1）；当mid位置的元素不等于target的时候，就表示当前区间没有target的这个元素，此时
 *    如果更新left，则left = left + 1;如果更新right，则right = right - 1;
 *
 * 左闭右开解法的三个问题：
 * 1. 由于是左闭，所以left取值必须为数组的合法元素，left初始化为0；由于右开，所以right初始值不一定是数组的合法元素位置，所以right = arr.length
 * 2. 循环不变条件：由于是左闭右开，那么我们循环的条件一定是left < right
 * 3. 左右指针更新后的取值问题：首先我们明确一个先决条件，那就是mid的取值，一定是合法的数组元素位置；那么当nums[mid] > target的时候,此时right = mid(由于是右开区间，mid不会被下重复扫描);
 *    当nums[mid] < target，left = mid + 1(由于是左闭区间，left必须在mid的基础上+1，否则mid可能会被重复扫描)
 **/
public class BinarySearch_704 {
    /**
     * 左闭右闭
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }


    /**
     * 左闭右开
     * @param nums
     * @param target
     * @return
     */
    public int search_2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }


}
