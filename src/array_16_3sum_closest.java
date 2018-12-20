/*
Given an array nums of n integers and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */

import java.util.Arrays;

/*
给定有n个数字的数组和一个目标数字，
找到三个数字，三个数字的和接近目标数字。
返回三个数字之和。每个输入只有一个答案
 */
class array_16_3sum_closest {
    static int threeSumClosest(int[] nums, int target) {
        int diff = 0;
        boolean isStart = true;
        int lastSum = 0;
        int i, j, k = 0;
        for (i = 0; i < nums.length; i++){
            for (j = 0; j < i; j++){
                for (k = i+1; k >i; k ++){
                    if (k >= nums.length){
                        break;
                    }
                    int sum = nums[k]+nums[j]+nums[i];
                    int tempdiff = Math.abs(sum-target);
                    if (isStart){
                        diff = tempdiff;
                        lastSum = sum;
                        isStart = false;
                    }else if (diff > tempdiff){
                        diff = tempdiff;
                        lastSum = sum;
                    }
                }
            }
        }
        return lastSum;
    }

    /*
    思路：三数循环，不过时间复杂度比较高，需要做一下优化，前两个数遍历，第三个进行二叉查找
     */

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }

}
