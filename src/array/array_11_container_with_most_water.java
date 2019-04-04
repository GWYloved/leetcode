package array;/*
Given n non-negative integers a1, a2, ..., an ,
where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

/*
给定一系列的非负整数(a1, a2, a3...)，每个代表一个点，
坐标为（i, ai）,因此画出了很多垂直的竖线，需要找到一条与X轴平行的线，
这条线和x轴中间的区域是一个容器，确保这容器的面积最大。
返回最大的面积
 */
public class array_11_container_with_most_water {
    private static int maxArea(int[] height) {
        int size = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int tempSize = Math.abs(j - i) * Math.min(height[j], height[i]);
                if (size < tempSize) {
                    size = tempSize;
                }
            }
        }
        return size;
    }

    //test
    public static void main(String[] args) {
        int[] heigh = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(heigh));
    }

    /**
     * 解题思路：暴力循环即可,复杂度O(n^2)
     */

    /**
     * 最佳方案，复杂度是O(n)
     * 通过while来进行指针的挪动
     */
    public int maxArea1(int[] height) {

        int l = 0, r = height.length - 1;
        int max = 0;

        while (l < r) {

            int hl = height[l];
            int hr = height[r];
            int ht = 0;

            if (hl < hr) {
                //当左边比右边短时，利用左边和横轴计算出第一个面积
                ht = hl * (r - l);

                // anything smaller than or equal to hl will hold less water
                //通过一个while来进行指针的迁移，迁移至左边高度增加时截止
                //思想：如果左边一直不大于初始的左边或者小于初始的左边时，由于横轴一直在减少，所以不可能面积大于初始的面积，唯有高度增加时才有可能
                while ((l < r) && hl >= height[++l]) ;
                //此时指针已经挪到了高点，需要再次判断左右的高度，跳到之前的while中

            } else {
                ht = hr * (r - l);

                // anything smaller than or equal to hr will hold less water
                while ((l < r) && hr >= height[--r]) ;
            }
            //每次面积计算之后保存最大值
            max = Math.max(max, ht);
        }

        return max;
    }
}
