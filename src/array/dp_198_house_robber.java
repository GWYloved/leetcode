package array;

import java.util.Arrays;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class dp_198_house_robber {
    public static int rob(int[] nums) {
        int tempMax = 0;
        int temp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i ++){
            temp[i] = i == 0? nums[0]: i == 1? Math.max(nums[0], nums[1]):Math.max(temp[i - 2] + nums[i], temp[i - 1]);
            if (temp[i] > tempMax){
                tempMax = temp[i];
            }
        }
        return tempMax;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,1,3,4}));
    }

    /**
     * 思路：需要记录下每一个当前值最大可能抢劫的值
     * 状态转移方程为，i == 0时，当前最大为nums[0]
     *              i == 1时，当前最大为Math.max(nums[0], nums[1])
     *              i == 2时,当前最大为Math.max(nums[0] + nums[2], nums[1])
     *              i > 2是， 当前最大为Math.max(temp[i - 2]+nums[i], temp[i -1])
     *    时刻记录最大值，最后返回最大值即可
     */
}
