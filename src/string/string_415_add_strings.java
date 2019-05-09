package string;
/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class string_415_add_strings {
    public static String addStrings(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        StringBuilder s = new StringBuilder();
        int remain = 0;
        for (int i = 0; i < maxLength; i ++){
            int[] a;
            if (i < num1.length() && i < num2.length()){
                a = add(num1.charAt(num1.length() - i- 1) - 48, num2.charAt(num2.length() - i - 1) - 48, remain);
            }else if (i < num1.length()){
                a = add(num1.charAt(num1.length() - i- 1) - 48, 0 ,remain);
            }else {
                a = add(0, num2.charAt(num2.length() - i - 1) - 48, remain);
            }
            s.append(a[0]);
            remain = a[1];
        }
        if (remain > 0){
            s.append(1);
        }
        return s.reverse().toString();
    }

    private static int[] add(int a, int b,int remain){
        int sum = a + b + remain;
        if (sum >= 10){
            return new int[]{sum%10, 1};
        }else {
            return new int[]{sum, 0};
        }
    }

    public static void main(String[] args) {
        System.out.println("0".charAt(0) - 48);
        System.out.println(addStrings("1000","2000"));
        System.out.println(addStrings("1","99"));
        System.out.println(addStrings("23","24"));
        System.out.println(addStrings("0","0"));
    }

    /**
     * 思路：和第67题是一模一样的解决方法
     */
}
