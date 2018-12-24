/*
Given an array nums of n integers and an integer target,
are there elements a, b, c,
and d in nums such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class array_18_4sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;
        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < length-3; i ++){
            int a = nums[i];
            for (int j = i+1; j < length-2; j++){
                int b = nums[j];
                int c_index = j+1;
                int d_index = length-1;
                //两端重合
                while (c_index < d_index) {
                    int total = a + b + nums[c_index] + nums[d_index];
                    int diff = target - total;
                    if (a + b + nums[c_index] + nums[d_index] == target) {
                        List<Integer> list = Arrays.asList(a, b, nums[c_index], nums[d_index]);
                        if (!answers.contains(list)){
                            answers.add(list);
                        }
                        c_index++;
                    } else {
                        if (diff > 0) {
                            //和过小
                            c_index++;
                        } else {
                            //和过大
                            d_index--;
                        }
                    }
                }
            }
        }
        System.out.println(answers);
        return answers;
    }

    public static void main(String[] args) {
        int[] s = new int[]{-1,0,1,2,-1,-4};
        fourSum(s,-1);
    }
    /**
     * 解题思路：第一个第二个用循环，第三个第四个用指针
     */
}
