package dynamic_programming;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
class dp_70_climbing_stairs {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        return fel(n);
    }

    private static int fel(int n) {
        int f1 = 1;
        int f2 = 1;
        int prePreFib = f1;
        int preFib = f2;
        int fib = 0;
        int flag = 1;

        if (n == 0 || n == 1) {
            return f1;
        }
        if (n >= 2) {
            while (flag < n) {
                fib = preFib + prePreFib;
                prePreFib = preFib;
                preFib = fib;
                flag++;
            }
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(fel(0));
        System.out.println(fel(1));
        System.out.println(fel(2));
        System.out.println(fel(3));
        System.out.println(fel(4));
    }
    /**
     * 思路：这个题目大问题是求总步数，但是是动态规划的地方，因此此时需要将这个问题分割成小问题
     * 步数只为1时，只有1，此时只有1个解法
     * 步数为2时，有1/1,2共2种解法
     * 步数为3时，有1/1/1,2/1,1/2，共三种解法
     * 步数为4时，有1/1/1/,2/1/1,1/2/1,1/1/2,2/2
     * 很容易抽象出，步数每多一步，事实上是原来的步数的方法上面，每个步法后面加了1，然后由于多的这一步可以和前一步合成一个2，然后就可以看成
     * 在前2步的每个步法后面加了个2，因此其实就是前一步的方法的和加上前两步的方法的和
     * 所以归纳为其实就是一个斐波那契数列
     */

    /**
     * 我的写法基本上就是最佳实践了
     */
}
