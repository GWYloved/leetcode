/*
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
        for (int i = 0; i < height.length;i ++){
            for (int j = 0; j < height.length; j ++){
                int tempSize = Math.abs(j-i)*Math.min(height[j],height[i]);
                if (size < tempSize){
                    size = tempSize;
                }
            }
        }
        return size;
    }

    //test
    public static void main(String[] args) {
        int[] heigh = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heigh));
    }

    /**
     * 解题思路：暴力循环即可
     */
}
