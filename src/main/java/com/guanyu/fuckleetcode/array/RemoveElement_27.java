package com.guanyu.fuckleetcode.array;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  链接：https://leetcode.cn/problems/remove-element
 *
 * @author zhanglu01
 * @date 2023-03-10 2:45 PM
 **/
public class RemoveElement_27 {
    /**
     * 双指针法，将数组中值为目标值的元素跟数组尾部的元素对调，这样就把要删除的元素全部放到数组尾部，我们只要返回数组的前半部分就行
     * 具体做法：
     * 1. 两个指针分别从数组的开头和结尾相向遍历
     * 2. 左指针遇到负责找到值等于给定val的元素；右指针负责找到值不等于val的元素；然后两个位置的元素
     * 3. 直到左右指针相遇
     *
     * 缺点：要处理的边界条件比较多
     * @param nums
     * @param val
     * @return
     */
    public int removeElement_1(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;

        //确定循环不变条件，只要左右指针未相遇，就要一直遍历
        while (l < r) {
            //如果左指针对应的元素等于val,并且右指针所指的元素不等于val,则交换左右指针所指的元素

            //遍历，找到左指针指向的置为val的元素
            while(l < (nums.length) && nums[l] != val) l++;
            if (l >= nums.length - 1) {
                return l;
            }

            //遍历,找到右侧指针指向的不为val的元素
            while(r > l && nums[r] == val) r--;
            swp(nums, l, r);
        }

        if (nums[r] != val) return r + 1;
        return r;
    }

    private void swp(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }


    /**
     * 快慢双指针法
     * 核心思想：遍历数组，将数组中值不等于val的元素，全部移动到数组头部；
     * 1. 定义一快一慢，两个指针；
     * 2. 其中快指针负责找出值不等于val的元素，然后放到数组头部
     * 3. 慢指针则负责标记数组头部中，值等于val的子数组中最后一个元素的位置
     * @param nums
     * @param val
     * @return
     */
    public int removeElement_2(int[] nums, int val) {
        if(nums == null  || nums.length == 0) {
            return 0;
        }
        int s = 0;
        int f = 0;
        while(f < nums.length) {
            if(nums[f] != val) {
                nums[s] = nums[f];
                s ++ ;
            }
            f ++;
        }
        return s;
    }
}
