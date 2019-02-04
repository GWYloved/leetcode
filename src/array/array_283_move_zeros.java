package array;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class array_283_move_zeros {
    public void moveZeroes(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] != 0){
                nums[flag++] = nums[i];
            }
        }
        for (int i = flag; i < nums.length; i ++){
            nums[i] = 0;
        }
    }

    /**
     * 思路：这题比较无聊...不过将这个处理一下比较好
     */

}