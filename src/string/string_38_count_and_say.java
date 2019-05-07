package string;
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */
public class string_38_count_and_say {
    public static String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        String before = countAndSay(n - 1);
//        String[] temp = before.split("");
        int last = -1;
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < before.length(); i ++){
            if (before.charAt(i) - 48 != last){
                if (last != -1){
                    stringBuilder.append(count).append(last);
                }
                last = before.charAt(i) - 48;
                count = 1;
            }else {
                count ++;
            }
        }
        if (count != 0){
            return stringBuilder.append(count).append(last).toString();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String t = "111";
        System.out.println(t.charAt(2));
        System.out.println(String.valueOf(t.charAt(2)));
        System.out.println(Integer.valueOf(t.charAt(2) - 48));
        System.out.println(countAndSay(1));

        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }

    /**
     * 思路：这一题刚开始决定使用split来进行分割，但是有个问题就是split也是耗时的，因此后期决定使用charat来进行定位，但是charat需要剪掉48才是应该的数字
     */
}
