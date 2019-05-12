package string;

import java.util.Arrays;

/*
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".


Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.


Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.


Note:

All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.
 */
public class string_443_string_compression {
    public static int compress(char[] chars) {
        char last = ' ';
        int lastCount = 0;
        char[] temp;
        int count = 0;
        for (int i = 0 ; i < chars.length; i ++){
            if (last!= chars[i]){
                if (lastCount > 1){
                    temp = String.valueOf(lastCount).toCharArray();
                    chars[count] = last;
                    count ++;
                    for (int j = 0; j < temp.length; j ++){
                        chars[++count -1] = temp[j];
                    }
                }else if (lastCount == 1){
                    chars[count] = last;
                    count ++;
                }
                last = chars[i];
                lastCount = 1;
            }else {
                lastCount++;
            }
        }
//        System.out.println(count);
//        System.out.println(Arrays.toString(chars));
        if (lastCount > 1){
            temp = String.valueOf(lastCount).toCharArray();
            chars[count] = last;
            count ++;
            for (int j = 0; j < temp.length; j ++){
                chars[ ++count -1] = temp[j];
            }
        }else if (lastCount == 1){
            chars[count] = last;
            count ++;
        }
//        System.out.println(Arrays.toString(chars));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    /**
     * 这题总体上来讲思路还是挺巧妙的
     */
}
