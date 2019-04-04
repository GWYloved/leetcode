package array;

/*
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
 */
public class array_746_min_cost_climbing_stairs {
    public int minCostClimbingStairs(int[] cost) {
        int flag1 = 0;
        int flag2 = 0;
        for (int i1 : cost) {
            int temp = i1 + Math.min(flag1, flag2);
            flag2 = flag1;
            flag1 = temp;
        }
        return Math.min(flag1, flag2);
    }
    /**
     * 思路：关于动态规划的题目一直都做不好，我觉得这题的思路困于如何跳级求解。
     * 但是这种问题事实上是需要求出每个点的最优解。
     * 因此从第一个台阶就需要逐个计算，第一个台阶的最优解就是COST1，第二个的话就是第0个和第1个的最小值加上COST2，这样逐个才能计算出结果
     */
}
