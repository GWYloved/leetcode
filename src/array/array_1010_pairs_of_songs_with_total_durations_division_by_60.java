package array;

import java.util.Arrays;

/*
In a list of songs, the i-th song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.



Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.


Note:

1 <= time.length <= 60000
1 <= time[i] <= 500
 */
public class array_1010_pairs_of_songs_with_total_durations_division_by_60 {
    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length; i ++){
            for (int j = i+1; j < time.length; j ++){
                if (time[i] >=0 && time[j] >=0 && (time[i] + time[j]) > 0 && (time[i] + time[j]) % 60 == 0){
                    count ++;
                }
            }
        }
        return count;
    }

    public static int numPairsDivisibleBy60_1(int[] time) {
        int[] temp = new int[60];
        int count = 0;
        for (int i : time){
            count += temp[(60 - i %60 )% 60];
            temp[i % 60]++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60_1(new int[]{30,20,150,100,40}));
        System.out.println(numPairsDivisibleBy60_1(new int[]{60,60,60}));
    }

    /**
     * 思路：这题的意思是求出两个数的和为60的整数的个数，如果暴力遍历会导致超时
     * 相反，使用这种固定数组来找出对应的数字比较简单。
     */
}
