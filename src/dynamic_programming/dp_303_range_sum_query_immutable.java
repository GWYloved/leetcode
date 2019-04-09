package dynamic_programming;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class dp_303_range_sum_query_immutable {
    int[] temp;
    public dp_303_range_sum_query_immutable(int[] nums) {
        temp = new int[nums.length];
        for (int i = 0; i < nums.length; i ++){
            temp[i] = i == 0? nums[0]: temp[i - 1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j > temp.length){
            return 0;
        }
        if (i == 0){
            return temp[j];
        }else {
            return temp[j] - temp[i -1];
        }
    }

    public static void main(String[] args) {
        dp_303_range_sum_query_immutable dp_303_range_sum_query_immutable = new dp_303_range_sum_query_immutable(new int[]{-2,0,3,-5,2,-1});
        System.out.println(dp_303_range_sum_query_immutable.sumRange(0,2));
        System.out.println(dp_303_range_sum_query_immutable.sumRange(2,5));
        System.out.println(dp_303_range_sum_query_immutable.sumRange(0,5));

    }

    /**
     * 思路，记录，记录，只要记录到位，大问题化为小问题，小问题化为记录的数据对比问题
     */
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */