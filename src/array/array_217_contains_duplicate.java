package array;

/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */

import java.util.Arrays;

public class array_217_contains_duplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2){
            return false;
        }
        Arrays.sort(nums);
        int before = nums[0];
        for (int i =1; i < nums.length; i++){
            if (before == nums[i]){
                return true;
            }else {
                before = nums[i];
            }
        }
        return false;
    }
    /**
     * 思路：这题真的是就为了让排个序吗？
     */
}
