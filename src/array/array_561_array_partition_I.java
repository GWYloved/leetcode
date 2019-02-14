package array;

import java.util.Arrays;

/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
 */
class array_561_array_partition_I {

    public int arrayPairSum(int[] nums) {
        int n = nums.length / 2;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += nums[2 * i];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum2(new int[]{1,4,3,2}));
    }


    /**
     * 思路：没啥特别的，复杂度在排序这儿nlogn
     * 不过竟然有最佳实践
     * 这个最佳实践基本上就是取巧，空间换时间
     * 最佳时间思路：因为给定了数字从[-10000,10000]，所以给一个20001位的标记空间
     * 标记空间标记了某个数加上100000那位是否存在，这样所有数的存在都已经在空间里面标记出来了这样做了一个去重并排序的操作
     * 这之后每隔2位加一下就出结果了
     * 这个通过声明一段空间，然后将这段空间作为一个计数的功能，称为counting-sort,这个操作不单排序，还去重了，不过这么大的空间浪费率，在空间需要的情况下，最好还是不要使用
     */
    public static int arrayPairSum2(int[] nums) {
        int N = 10000, min = Integer.MAX_VALUE;
        boolean[] exist = new boolean[2*N+1];

        for (int i = 0; i < nums.length; i++) {
            exist[nums[i] + N] = true;
            min = Math.min(min, nums[i] + N);
        }
        System.out.println(min);
        int sum = 0;
        boolean odd = true;
        for (int i = min; i < exist.length; i++) {
            if (!exist[i]) continue;
            if (odd) sum += i - N;
            odd = !odd;
        }
        return sum;
    }
}
