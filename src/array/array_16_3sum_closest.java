package array;/*
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

    /**
     * 最佳方案：复杂度在O(nlogn)到O(n^2)之间
     */
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);//排序,O(nlogn)
        int res = nums[0] + nums[1] + nums[2];//计算开头三个的值
        for(int i = 0;i<nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;//排序完成之后如果有相等的就跳过
            int min = nums[i] + nums[i+1] + nums[i+2];
            if(min > target){
                //由于已经排序过了，所以此时和如果比目标大，那么之后的肯定都会大了。
                //此时计算是应该返回res还是min
                if(Math.abs(res-target) < min-target) return res;
                else return min;
            }
            //正常情况，指针项和后两项的和比目标值小，此时需要找接近目标的最大值
            int max = nums[i] + nums[nums.length-1] + nums[nums.length-2];
            //指针项和末尾两项的和和目标进行比较，目的是找到和最后两项的和比目标值大的项
            if(max < target){
                res = max;
                continue;
            }
            //此时已经确定在指针项和末项之间，有两项与指针项的和是比目标值小，但是最接近的，此时只挪动了一根指针就确定了范围
            int l = i+1;//左指针从左出发
            int r = nums.length-1;//右指针从右侧出发
            //寻找该两项
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(sum-target) < Math.abs(res-target)) res = sum;
                if(sum > target) while(l<r && nums[r--] == nums[r]);//和比目标值大右指针左移
                else if(sum < target) while(l<r && nums[l++] == nums[l]);//和比目标值小，左指针右移
                else return target;//找到了相等的，直接返回即可
            }
        }
        return res;//没那么多幺蛾子了，就三项，只能返回该值
    }
}
