package dynamic_programming;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
//经典最大回文子串问题
class dp_5_longest_palindromic_substring {
    public static String longestPalindrome(String s) {
        String REG = "*";
        if (s.length() < 1) {
            return "";
        }
        String temp = "";
        String[] schar = s.split("");
        List<String> tempList = new ArrayList<>();
        int index = 0;
        int originsize = schar.length;
        while (index < originsize) {
            tempList.add(REG);
            tempList.add(schar[index]);
            index++;
        }
        tempList.add(REG);
        for (int i = 1; i < tempList.size(); i += 2) {
            if (temp.length() / 2 > tempList.size() - i) {
                break;
            }
            int t = i;
            while (
                    --t >= 0
                            && 2 * i - t < tempList.size()
                            && tempList.get(t).equals(tempList.get(2 * i - t))) ;//此时指针挪到了最小的地方-1的地方
            t++;
            if (2 * i - 2 * t + 1 > temp.length()) {
                temp = String.join("", tempList.subList(t, 2 * i - t + 1));
            }
        }
        return temp.replace(REG, "");
    }

    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 思路：最大回文串之前接触过，使用马拉车算法，就是每个间距插入一个占位符，用这个占位符来进行回文处理
     * 我的想法是，一根指针从头开始遍历，然后从这根指针衍生出两根指针，一个向前一个向后，不断挪动相同的间距，
     * 直到出现两根指针的对应值不同为止，这样就已经找到了这个值对应的最大回文串，之后在挪动指针不断进行
     * 马拉车算法的复杂度都是O(n^2)
     */

    /**
     * 动态规划解这条题目，也就是需要将这个问题拆分成小问题
     * fun(i,j){
     * if(i == j){
     * //此时代表两根指针重合
     * return true;
     * }
     * if(i - j == 1){
     * //此时代表两根指针只差一位，在回文串的领域里面，就需要直接判断这两个是否相等即可
     * return a[i] == a[j];
     * }
     * if(i - j > 1){
     * //此时代表两根指针差不止一位，那就需要不断往内部遍历，直到最后在差一位的时候或者
     * return a[i] == a[j] && fun(j+1, i-1);
     * }
     * }
     * 当fun返回true的时候，就代表这段是回文串了。但是有个问题，就是这个fun的记录方式，伪代码是这么写，但是记录方式不可以这样操作
     * 需要用一个二维数组记录每个i，j对应的是否是回文串，这样在后续递归的时候才能直接获取之前的记录。
     * 和一般的由上而下的递归相比，动态规划的递归方式，更像是由下而上
     * 复杂度为O(n^2)
     */
    public static String longestPalindrome1(String s) {
        int length = s.length();
        String result = "";
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1]);
                if (dp[i][j] && i - j + 1 > result.length()) {
                    result = s.substring(j, i + 1);
                }
            }
        }
        return result;
    }

    /**
     * 正常的马拉车算法实践，不需要我那么多步骤，同时时间上面是O(n),不过仍然使用了一个存储空间用于记录某位置已获得的最大回文串长度
     */
    public static String longestPalindromeLinear(final String in) {
        /*
         * Normalize the length of the string by inserting special character ‘$’ in the space between each pair of
         * characters in the input and the two outside edges. This is done merely to make the computation identical for
         * both odd and even length input string.
         */
        final StringBuffer sb = new StringBuffer();
        sb.append('$');
        for (int i = 0; i < in.length(); i++) {
            sb.append(in.charAt(i));
            sb.append('$');
        }
        //直接通过操作string来设置马拉车回文串
        final String S = sb.toString();
        int c = 0; // contains center of current palindrome
        int max = 0; // contains the right edge of current palindrome

        // P[i] contains the length of longest palindrome (in S, not original) centered at i
        final int[] P = new int[S.length()];
        String temp = "";
        for (int i = 0; i < P.length; i++) {
            P[i] = 0;
        }
        // for each position find longest palindrome centered at the position, save length in P
        for (int i = 1; i < S.length() - 1; i++) {
            final int i_mirror = 2 * c - i; // as (C - i_mirror) = (i - C) due to symmetric property

            /*
             * When max-i > P[i_mirror] then palindrome at center i_prime contained completely within palindrome
             * centered at c. Else max-i <= P[i_mirror] means that the palindrome at ceter i_mirror doesn’t fully
             * contained in the palindrome centered at c. In that case palindrome at i could be extended past max.
             */
            P[i] = (max > i) ? Math.min(P[i_mirror], max - i) : 0;

            // Try to expand the palindrome centered at i. if the palindrome centered at i could be extended past max
            // then extend max to the right edge of newly extended palindrome
            while ((i + P[i] + 1) < S.length() && (i - P[i] - 1) >= 0
                    && S.charAt(i + P[i] + 1) == S.charAt(i - P[i] - 1)) {
                P[i]++;
                //p[i]记录了各坐标位置的最大回文串，必须要记录，否则无法找到子串的状态
            }
            // If palindrome centered at was extend past max then update Center to i and update the right edge
            if (i + P[i] > max) {
                c = i;
                max = i + P[i];
            }
        }
        int longestCenter = 0;
        int longestLength = 0;

        for (int i = 0; i < P.length; i++) {
            if (P[i] > longestLength) {
                longestLength = P[i];
                longestCenter = i;
            }
        }

        final int offset = (longestCenter - longestLength) / 2;
        return in.substring(offset, offset + longestLength);
    }
}
