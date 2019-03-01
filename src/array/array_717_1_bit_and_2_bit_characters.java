package array;

/*
We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

Example 1:
Input:
bits = [1, 0, 0]
Output: True
Explanation:
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
Example 2:
Input:
bits = [1, 1, 1, 0]
Output: False
Explanation:
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
Note:

1 <= len(bits) <= 1000.
bits[i] is always 0 or 1.
 */
class array_717_1_bit_and_2_bit_characters {
    public static boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        for (int i = 0; i < length; i++) {
            if (bits[i] == 1) {
                i++;
                continue;
            }
            if (i == length - 1) {
                return bits[i] == 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 0, 1, 0}));
    }

    /**
     * 思路：这题略无聊，主要是指针的移动，如果当前数字是1，往后挪一位在++，如果当前是0，直接++，最后判断指针是否落在最后一位即可。
     */
}
