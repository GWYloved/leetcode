package string;

import java.util.Arrays;

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class string_387_first_unique_character_in_a_string {
    public static int firstUniqChar(String s) {
        int[] temp = new int['z'-'a'+1];
        for (int i =0; i < s.length(); i ++){
            int index = s.charAt(i) - 'a';
//            System.out.println("index = "+index);
            int a = temp[index];
            if (a == 0){
                temp[index] = i + 1;
            }else if (a > 0){
                temp[index] = -1;
            }
//            System.out.println("temp index = "+temp[index]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i ++){
//            System.out.println("now t = "+(char)(i + 'a')+"//and size = "+temp[i]);
            if (temp[i] > 0){
                if (temp[i] == 1){
                    return 0;
                }
                min = Math.min(temp[i] , min);
            }
        }
//        System.out.println(Arrays.toString(temp));
        return min != Integer.MAX_VALUE? min -1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    /**
     * 思路，same old thing
     */
}
