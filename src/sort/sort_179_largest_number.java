package sort;

import java.util.Arrays;
import java.util.Comparator;

class sort_179_largest_number {
    public static String largestNumber(int[] nums) {
        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp, new Comparator());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : temp) {
            stringBuilder.append(integer);
        }
        if (stringBuilder.toString().startsWith("0")) {
            return "0";
        }
        return stringBuilder.toString();

    }

    static class Comparator implements java.util.Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            if (s1.equals(s2)) {
                return 0;
            }
            if (s1.length() <= s2.length()) {
                for (int i = 0; i < s1.length(); i++) {
                    if ((int) s1.charAt(i) > (int) s2.charAt(i)) {
                        return -1;
                    } else if ((int) s1.charAt(i) < (int) s2.charAt(i)) {
                        return 1;
                    }
                }

                if (s1.length() == s2.length()) {
                    return 0;
                } else {
                    for (int i = s1.length(); i < s2.length(); i++) {
                        for (int j = 0; j < s1.length(); j++) {
                            if ((int) s1.charAt(j) < (int) s2.charAt(i)) {
                                return 1;
                            } else if ((int) s1.charAt(j) > (int) s2.charAt(i)) {
                                return -1;
                            }
                        }

                    }
                    return 0;
                }
            } else {
                for (int i = 0; i < s2.length(); i++) {
                    if ((int) s1.charAt(i) > (int) s2.charAt(i)) {
                        return -1;
                    } else if ((int) s1.charAt(i) < (int) s2.charAt(i)) {
                        return 1;
                    }
                }
                for (int i = s2.length(); i < s1.length(); i++) {
                    for (int j = 0; j < s2.length(); j++) {
                        if ((int) s1.charAt(i) < (int) s2.charAt(j)) {
                            return 1;
                        } else if ((int) s1.charAt(i) > (int) s2.charAt(j)) {
                            return -1;
                        }
                    }

                }
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
//                1,11
//                30,3
//                1,13
                2, 10
//                8247,824
//                121,12
//                26, 33, 19, 29, 61, 66, 52, 37, 7, 76, 89, 93, 72, 2, 82, 11, 9, 41, 47, 76, 80, 28, 86, 30, 99, 25, 99, 85, 96, 98, 88, 33, 4, 94, 25, 80, 19, 55, 82, 71, 29, 61, 15, 2, 57, 98, 15, 91, 27, 95, 47, 38, 66, 2, 78, 26, 77, 33, 23, 90, 73, 27, 20, 5, 38, 23, 35, 29, 13, 46, 6, 71, 58, 37, 89, 28, 8, 1, 8, 73, 81, 83, 77, 22, 63, 36, 62, 89, 94, 43, 25, 86, 53, 21, 94, 9, 40, 19, 24, 21
//                1145134726, -682584886, 1895454242, 2004378087, -1855696367, 1813048944, -1506811635, -1271811878, 1612219267, 838774780, -1749593269, -1721719275, 1908610116, 1732597731, 958982535, -937016328, 122618972, 775687877, -466649843, 1212803556, 2141188937, -1192216148, 815915713, 2001074718, 590322195, 1498442902, 1985922385, 417233400, 1631605406, -1900707536, -1345360210, -1732308942, -287293378
        };
        System.out.println(largestNumber(nums));
    }

    /**
     * 解题思路：
     * 这题主要是定下一个最大数规则
     * 规则我是这么立的
     * 1.两个数长度相同时，逐位比较，直到某个数的某个位比另一个位大，这样大的放前面
     * 2.A数长度大于B数时，先逐位比较，如1步，直到B数达到末位，之后将A数的剩余的几位，每一位都和B数从头对比
     * 比较结果一旦出现A数剩余几位大的，就将A数放在前面，出现A数剩余几位小的，就将B数放在前面，相等就随意。
     */
}
