package string;
/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
public class array_67_add_binary {
    public static String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());
        int remain = 0;
        int[] t;
        for (int i = 0; i < maxLength; i ++){
            if (i < a.length() && i < b.length()){
                t = add(a.charAt(a.length() - i -1) - 48, b.charAt(b.length() - i -1) - 48, remain);
            }else if (i < a.length()){
                t = add(a.charAt(a.length() - i -1) - 48, 0 ,remain);
            }else {
                t = add(0, b.charAt(b.length() - i - 1) - 48, remain);
            }
            s.append(t[0]);
            remain = t[1];
        }
        if (remain > 0){
            s.append(remain);
        }
        return s.reverse().toString();
    }

    private static int[] add(int a, int b, int remain){
        int sum = a + b + remain;
        switch (sum){
            case 0:
                return new int[]{0,0};
            case 1:
                return new int[]{1,0};
            case 2:
                return new int[]{0,1};
            case 3:
                return new int[]{1,1};
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
        System.out.println(addBinary("1010","1011"));
        System.out.println(addBinary("0","0"));
        System.out.println(addBinary("111","1"));
        System.out.println(addBinary("111","0"));
    }
    /**
     * 我已不知道怎么优化了
     */
}
