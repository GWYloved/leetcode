package string;

/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

 */
public class string_541_reverse_string_ll {
    public static String reverseStr(String s, int k) {
        if (k == 1){
            return s;
        }
//        StringBuilder st = new StringBuilder();
//        StringBuilder temp = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            int t = i % (2 * k);
//            if (t == 0){
//                if (i == s.length() - 1){
//                    st.append(s.charAt(i));
//                }else {
//                    temp.delete(0,temp.length());
//                    temp.append(s.charAt(i));
//                }
//            }else if (t < k){
////                temp.insert(0, s.charAt(i));
//                temp.append(s.charAt(i));
//                if (t == k -1 || i == s.length() -1){
//                    st.append(temp.reverse());
//                }
//            }else {
//                st.append(s.charAt(i));
//            }
//        }
//        return st.toString();
        char[] t = s.toCharArray();
        for (int i = 0; i < s.length(); i +=2 * k){
            int flag1 = i;
            int flag2 = i + k - 1;
            if (flag2 > s.length() -1){
                flag2 = s.length() -1;
            }
            while (flag1 < i + k - 1 && flag2 > i && flag1 < flag2){
                char temp = t[flag1];
                t[flag1] = t[flag2];
                t[flag2] = temp;
                flag1 ++;
                flag2 --;
            }
        }
        return String.valueOf(t);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
        System.out.println(reverseStr("abc",1));
        System.out.println(reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl",39));
    }
    /**
     * 解体思路：一般这种题目我喜欢用stringbuilder来做，但是stringbuilder的insert复杂度是O(n * n)
     * 换个思路直接使用char数组来做，就可以避免这个问题了
     */
}
