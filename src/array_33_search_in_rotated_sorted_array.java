/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
class array_33_search_in_rotated_sorted_array {
    public static int search(int[] nums, int target) {
        //题目中要求了o(logn)，就是规定了必须要二叉查找，但是该数组其实是部分有序的，有序就是给加了一些额外的技巧
        //单纯的二分查找需要先排序，这个数组可以从头部和尾部两个来看，如果目标值比头部大，代表从头部索引比较好，如果比尾部小，代表从尾部索引比较好
        //在索引之前需要找到这个指针点的位置，然后就能划分区域。
        int length = nums.length;
        if (length < 1){
            return -1;
        }
        if (length == 1){
            return nums[0] == target? 0:-1;
        }
        if (target == nums[0]){
            return 0;
        }
        if (target == nums[length - 1]){
            return length -1;
        }

        if (target > nums[0]){
            //此时目标值比头部还大，代表需要从头部往后索引
            //索引到相同的返回，索引到比他还大的，直接返回-1
            int index = 1;
            while (index <= length-1 && nums[index++] < target);
            return (index-- <= length && nums[index] == target)? index : -1;
        }else if (target < nums[length -1]){
            //此时目标值比尾部还小，代表需要从尾部往前索引
            int index = length -2;
            while (index >= 0 && nums[index -- ] > target);
            return (index++ >=-1 && nums[index] == target)? index : -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,1};
        search(a, 4);
    }
    /*
    思路：虽然这题过了，平均时间为10ms，但是查找中间点的位置时间复杂度最复杂为O(n)因此其实是不符合的
     */
    /**
     * 最佳实践:直接通过二叉查找，中间点的大小其实已经可以确定该段区域是左半区还是右半区
     * 另外本来就已经和端点做过比较因此可以确定是在左半区查找还是右半区查找了，二叉查找几次就能确定半区了，
     * 确定半区也用二叉查找，这个做法比直接查找块很多了
     */
    public boolean isOnRight(int head, int mid, int target) {
        boolean targetOnRightSection = head > target;
        if (targetOnRightSection) {
            if (head <= mid) return true; // mid on left section
        } else {
            if (head > mid) return false; // mid on right section while target on left
        }
        return mid < target; // target on the right of mid
    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isOnRight(nums[0], nums[mid], target)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left] == target ? left : -1;
    }
}
