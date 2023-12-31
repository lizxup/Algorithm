package src.binarysearch;

import java.util.Arrays;

public class BinarySearch {

    /**
     * 二分查找基础版
     * @param nums
     * @param target
     * @return
     */
    public static int BinarySearchBasic(int[] nums, int target) {
        //对nums数组进行排序
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        //注意 left <= right 还需要判断left与right缩至指向相同元素的情况
        while (left <= right) {

            //防止int爆了，对于left+right 为奇数的时候 除以2 向下取整
            int middle = left + (right - left) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = left + 1;
            } else {
                return middle;
            }
        }
        //找不到return -1
        return -1;
    }

    /**
     * Attention
     * 1.left <= right
     * 2.(left + right) / 2 可能int会爆  （右移运算）
     */

    public static int binarySearchAlterNative (int[] nums, int target){
        Arrays.sort(nums);
        int left = 0;

        // first alter
        //right 所指向的查找范围  不包含所指元素
        int right = nums.length;

        //second alter
        while (left < right) {

            int middle = left + ((right - left) >>> 1);
            if (target < nums[middle]) {

                //third alter
                right = middle;

            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        //找不到return -1
        return -1;
    }


    /**
     * 搜索次数平衡版
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums , int target){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        while( 1 < right-left){
            int middle = left + ((right - left) >>> 1);
            if (target < nums[middle]) {
                right = middle;
            }
            else{
                left = middle;
            }
        }
        if (nums[left] == target){
            return left;
        }
        else{
            return -1;
        }
    }


    /**
     * java 文件中的官方写法
     * 如果没有查找到target  return的内容 为 -(target应该在被查找数组中的插入位置+1)
     * 为什么要加1
     * 保证查找失败返回负数，如果 target应该在被查找数组中的插入位置是0 那么返回就是 -0 不能保证查找失败返回负数
     *
     *
     * @param a 升序的数组
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return  index of the search key,
     * if it is contained in the array within the specified range; otherwise, (-(insertion point) - 1).
     */
    public static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }


    /**
     * nums中存在多个 target return 最左侧的targe的下标
     * @param nums
     * @param target
     * @return >=target的最靠左的索引（找到就是target最左侧位置，没找到就是查如位置）
     */
    public static int binarySearchFarLeft(int[] nums , int target){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target <= nums[middle]) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return left;
    }


    /**
     * nums中存在多个 target return 最右侧的targe的下标
     * @param nums
     * @param target
     * @return   <=target的最靠右的索引（找到就是target最右侧位置，没找到就是查入位置）
     */
    public static int binarySearchFarRight(int[] nums , int target){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (nums[middle] <= target) {
                left = middle + 1;
            }
        }
        return right;
    }












}
