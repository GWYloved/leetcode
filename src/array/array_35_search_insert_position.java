package array;

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */
class array_35_search_insert_position {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int low = 0, high = nums.length - 1;
        int middle = 0;
        while (low < high && high < nums.length) {
            middle = (low + high) >> 1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        if (high < middle) {
            return nums[high] >= target ? high : high + 1;
        }
        return nums[low] >= target ? low : low + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3};
        int target = 2;
        System.out.println(searchInsert(arr, target));
    }

    /**
     * 思想：此处尽可能使用二分查找，在最后查找出来之后，需要对high和low进行处理
     * 处理就分两种，一种是high对应的值比middle小，此时代表num[middle] < target,只需要判定nums[high] 是否比target大，大的话就放到high上，否则就是high+1;
     * 另一种是low大于middle，此时代表nums[middle] > target,只需要判定nums[low]是否比target小，小的话就放到low+1上，否则就放在low上；
     */
}
