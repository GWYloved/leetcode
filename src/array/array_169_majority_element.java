package array;

import java.util.Arrays;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
class array_169_majority_element {
    public static int majorityElement(int[] nums) {
        if (nums.length <= 1){
            return nums[0];
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int former = 1, last = 1;
        if (nums[0] == nums[1]){
            former = 1; last = 1;
        }else {
            former = 0; last = 0;
        }
        int flag = nums[0];
        int big = nums[0];
        for (int i = 1; i < nums.length; i ++){
            if (flag == nums[i]){
                last++;
                if (last > former){
                    big = nums[i];
                    former = last;
                }
            }else {
                flag = nums[i];
//                if (last > former){
//                    big = nums[i-1];
//                    former = last;
//                }
                last = 1;
            }
        }
        return big;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

}
