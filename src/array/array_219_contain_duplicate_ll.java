package array;

/*
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class array_219_contain_duplicate_ll {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        if (nums.length <= k + 1) {
            return containsDuplicate(nums);
        }
        int start = 0;
        int last = k;
        while (last < nums.length) {
            int[] temp = new int[k + 1];
            temp = Arrays.copyOfRange(nums, start, last + 1);
//            System.out.println(Arrays.toString(nums));
//            System.out.println(Arrays.toString(temp));
            if (containsDuplicate(temp)) {
                return true;
            }
            start++;
            last++;
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (before == nums[i]) {
                return true;
            } else {
                before = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    /**
     * 思路：这题可以拓展一下217的解法，不过不好
     * 正确的其实很简单，使用hashset即可，不过过于复杂的情况可能还是不是很好用，不过比我的多重操作好点
     * 这样复杂度最差为O(n*nlogn)
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
