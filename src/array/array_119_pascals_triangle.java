package array;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */
class array_119_pascals_triangle {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0){
            result.add(1);
            return result;
        }
        for (int i = 0; i <= rowIndex; i ++){
            if (i == 0 || i == rowIndex){
                result.add(1);
            }else {
//                result.add((int)((factorial(rowIndex)).divide((factorial(rowIndex - i))*factorial(i))));
                result.add((factorial(rowIndex).divide((factorial(rowIndex - i).multiply(factorial(i))))).intValue());
            }
        }
        return result;
    }

    private static java.math.BigDecimal factorial(int n) {
        java.math.BigDecimal sum = new java.math.BigDecimal(1);
        while( n > 0 ) {
            sum = sum.multiply(new java.math.BigDecimal(n--));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getRow2(32));
        System.out.println(factorial(32));
    }

    /**
     * 思路，这题类似于找规律，每个位置的值是C下缀index，上缀i，但是问题是这样计算的效率太低。不过用大数来计算的话，能存储很大很大很大
     */

    /**
     * 另一种思路：第N层的第M（M >= 0 && M <= N）个，其值是第N-1层的M-1个和M个之和，
     * 而使用一个数组来递推这个例子，思想还是比较丰富的，对比我使用的计算排列组合，这个无论是效率还是空间，都远远超过了我之前想的
     * 不过这种思路相当于计算第N个的时候将所有的都计算了一遍，如果计算单个元素，可能还是需要使用排列组合
     */

    public static List<Integer> getRow2(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }

        Integer[] row = new Integer[rowIndex + 1]; // ith row has i+1 nums
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int pre = row[0];
            for (int j = 1; j < i; j++) {
                int tmp = row[j];
                row[j] = pre + tmp;
                pre = tmp;
            }
            row[i] = 1;
            System.out.println(Arrays.toString(row));
        }

        return (List<Integer>) Arrays.asList(row);
    }
}
