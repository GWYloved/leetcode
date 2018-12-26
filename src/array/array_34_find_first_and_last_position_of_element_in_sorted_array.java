package array;

import java.util.Arrays;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
class array_34_find_first_and_last_position_of_element_in_sorted_array {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length < 1){
            return new int[]{-1,-1};
        }
        int low = 0;
        int high = nums.length - 1;
        int start = -1;
        int end = -1;
        while (low <= high && low < nums.length && high < nums.length){
            int middle = (low + high) >> 1;
            if (nums[middle] == target){
                start = middle;
                end = middle;
                while (start -- >= 1 && nums[start] == target);
                while (end ++ <= nums.length -2 && nums[end] == target);
                return new int[]{++start, --end};
            }else if (nums[middle] < target){
                low = middle+1;
            }else {
                high = middle -1;
            }
        }
        return new int[]{start, end};
    }
    /*
    思路分析：这题要求是O(logn)因此只能用二叉查找来确定值了，但是我在确定值之后需要确定范围，确定范围需要挪动指针，这个挪动的复杂度有点问题，如果在不确定的情况下可能会超出O(logn)变成o(n)
     */
    public static void main(String[] args) {
        int[] a = new int[]{5,7,7,8,8,10};
        int b = 8;
        System.out.println(Arrays.toString(searchRange1(a,b)));
    }
    /**
     * 最佳实践：第一次二叉查找并非查找这个数，二是查找到比这个数小的最大的数的指针位置，这样就确定了开始位置，而第二次二叉查找则是在这个数+1的情况下，
     * 查找比+1之后的这个数小的最大的位置，或者说按照第一次查找的反方向，查找比这个数大的数的最小的数的位置，这样就确定了结束的位置。
     */

    public static int[] searchRange1(int[] A, int target) {
        int start = firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }

}
