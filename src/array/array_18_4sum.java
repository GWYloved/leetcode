package array;/*
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

    /*
    最佳实践：
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for(int i=0; i < nums.length - 3; i++) {
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target)
                //指针项和后三项的和如果大于目标值，代表后续值都会大于目标值，此时中断即可
                break;
            if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target)
                //指针项值和末三项值之和如果小于目标值，代表指针项和末项之间不存在和大于目标值的
                continue;
            if(i>0 && nums[i-1]==nums[i])
                //指针项和前一项一样，如果前一项没有找到固定值的话，该项也找不到，所以应该跳过
                continue;

            for(int j=i+1; j<nums.length-2; j++) {
                //以下是三数求和的模板
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)
                    break;
                if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target)
                    continue;
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;

                int current = nums[i] + nums[j];

                int k = j+1;
                int l = nums.length-1;

                while(k<l) {
                    int sum = current + nums[k] + nums[l];
                    if(sum==target) {
                        result.add(Arrays.asList(new Integer[]{nums[i] , nums[j], nums[k], nums[l]}));
                        while(k<l && nums[k]==nums[k+1]) {
                            k++;
                        }
                        while(k<l && nums[l]==nums[l-1]) {
                            l--;
                        }

                        k++;
                        l--;
                    } else if(sum<target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return result;
    }
}
