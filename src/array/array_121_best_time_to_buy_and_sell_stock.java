package array;


/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class array_121_best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        int big = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    continue;
                }
                big = big > prices[j] - prices[i] ? big : prices[j] - prices[i];
            }
        }
        return big;
    }

//    public static int maxProfit1(int[] prices) {
//        boolean isDebug = true;
//        if (prices.length <= 1) {
//            return 0;
//        }
//        int start = 0;
//        int end = prices.length - 1;
//        int theBiggest = prices[prices.length - 1];
//        int theSmallest = prices[0];
//        int result = theBiggest - theSmallest;
//        //指针右移，找到左起第一个比最左小的数
//        while (start < end && prices[++start] >= theSmallest);
//        if (start >= (prices.length - 1)){
//            //没有比最左数小的数,此时只要找到最大的数即可
//            if (isDebug){
//                System.out.println("aaa没有找到比左更小的数，此时右起最大的数是"+theBiggest);
//            }
//            while (0 < end){
//                theBiggest = prices[--end] > theBiggest? prices[end]:theBiggest;
//                if (isDebug) {
//                    System.out.println("bbb没有比左更小的数的前提下，右起最大的数是"+theBiggest);
//                }
//            }
//            result =  theBiggest - theSmallest > 0? theBiggest - theSmallest : 0;
//        }else {
//            //存在比最左数小的数，此时从这个数到末尾，找到最大的数
//            if (isDebug) {
//                System.out.println("ccc左起第一个比最左小的数"+prices[start]);
//            }
//            theSmallest = prices[start];
//            int theBigIndex = end;
//            while (start < end){
//                if (prices[--end] > theBiggest && start < end){
//                    theBigIndex = end;
//                    theBiggest = prices[end];
//                }
//            }
//            if (isDebug) {
//                System.out.println("ddd找到比左更小的数之后，右起最大的数是"+theBiggest);
//            }
//            while (start < theBigIndex){
//                if (prices[++start] < theSmallest){
//                    theSmallest = prices[start];
//                }
//            }
//            if (isDebug) {
//                System.out.println("eee找到右起最大的数之后，从左起更小的数和右起最大的数之间存在的最小的数是"+theSmallest);
//            }
//            result = theBiggest - theSmallest;
//        }
//
//        start = 0;
//        end = prices.length -1;
//        theBiggest = prices[prices.length - 1];
//        theSmallest = prices[0];
//        //指针左移，找到右起第一个比最右大的数
//        while (start < end && prices[--end] <= theBiggest);
//        if (end <= 0){
//            //没有比最右数大的数,此时只要找到最小的数即可
//            if (isDebug){
//                System.out.println("fff没有找到比右更大的数，此时左起最小的数是"+theSmallest);
//            }
//            while (start < prices.length -1){
//                theSmallest = prices[++start] < theSmallest? prices[start]:theSmallest;
//                if (isDebug) {
//                    System.out.println("ggg没有比最右更大的数的前提下，左起最小的数是"+theSmallest);
//                }
//            }
////            result =  theBiggest - theSmallest > 0? theBiggest - theSmallest : 0;
//            if (isDebug){
//                System.out.println("此处返回了333 \n");
//            }
//            return theBiggest - theSmallest > result? theBiggest - theSmallest > 0? theBiggest - theSmallest : 0: result > 0? result:0;
//        }else {
//            //存在比最右数大的数，此时从这个数到开头，找到最小的数
//            if (isDebug) {
//                System.out.println("hhh右起第一个比最右大的数"+prices[end]);
//            }
//            theBiggest = prices[end];
//            int theSmallIndex = start;
//            while (start < end){
//                if (prices[++start] < theSmallest && start < end){
//                    theSmallIndex = start;
//                    theSmallest = prices[start];
//                }
//            }
//            if (isDebug) {
//                System.out.println("iii找到比右更大的数之后，左起最小的数是"+theSmallest);
//            }
//            while (end > theSmallIndex){
//                if (prices[-- end] > theBiggest){
//                    theBiggest = prices[end];
//                }
//            }
//            if (isDebug) {
//                System.out.println("jjj找到右起最大的数之后，从左起更小的数和右起最大的数之间存在的最大的数是"+theBiggest);
//            }
//            if (isDebug){
//                System.out.println("此处返回了4444 \n");
//            }
//            return theBiggest - theSmallest > result? theBiggest - theSmallest > 0 ? theBiggest - theSmallest : 0: result > 0? result : 0;
//        }
//    }


    /**
     *思路：穷举法比较容易想到，不过时间复杂度比较高，而onepass法则比较难想到
     * 思想主要是从头出发，遇到比已经遇到最小的值还小的话，就存储一下，否则就对比一下当前值和最小值的差值，如果这个差值比存储的差值还大的话就取用这个差值
     * 这样能保证差值是之前遇到的最小的值为底的值。而如果出现了最大差值之后，在遇到底就不会右反应了
     */
    public static int maxProfit1(int[] prices) {
        if (prices.length < 1){
            return 0;
        }
        int min = prices[0];
        int diff = 0;
        for (int i : prices){
            if (i < min){
                min = i;
            }else if (diff < i - min){
                diff = i - min;
            }
        }
        return diff;
    }




    public static void main(String[] args) {
        System.out.println("最终结果是" + maxProfit1(new int[]{2, 11, 1, 7, 6}));
    }
}
