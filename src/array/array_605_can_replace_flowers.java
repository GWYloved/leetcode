package array;
/*
Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.
 */
public class array_605_can_replace_flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flag = 1;
        int total = 0;
        for (int i = 0; i < flowerbed.length; i ++){
            if (flowerbed[i] == 0){
                flag ++;
            }else {
                flag = 0;
            }
            if (flag == 3 || flag == 2 && i == flowerbed.length -1){
                total ++;
                flag = 1;
            }
            if (total >= n){
                return true;
            }
        }
        return false;
    }

    /**
     * 思路：读懂题目是个问题，读懂了之后自己写case又是个问题，何时才能一次性写好不需要通过case来测试正确性呢？
     */
}
