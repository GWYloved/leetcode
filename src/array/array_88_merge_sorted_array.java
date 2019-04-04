package array;

import java.util.Arrays;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class array_88_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        quickSortByTwoPointer(nums1, 0, m + n - 1);
    }


    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] temp = Arrays.copyOf(nums1, nums1.length);
        int p1 = 0, p2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (p2 >= n || temp[p1] < nums2[p2] || !(temp[p1] == 0 && p1 >= m)) {
                nums1[i] = temp[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
        }
    }

    public static void quickSortByTwoPointer(int[] a, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int partitionIndex = getPartitionIndexByTwoPointer(a, startIndex, endIndex);
        quickSortByTwoPointer(a, startIndex, partitionIndex - 1);
        quickSortByTwoPointer(a, partitionIndex + 1, endIndex);
    }

    private static int getPartitionIndexByTwoPointer(int[] a, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = a[startIndex];
        while (left != right) {
            while (left < right && a[right] > pivot) {
                right--;
            }
            while (left < right && a[left] <= pivot) {
                left++;
            }
            if (left < right) {
                a[left] = a[left] + a[right];
                a[right] = a[left] - a[right];
                a[left] = a[left] - a[right];
            }
        }
        a[startIndex] = a[left];
        a[left] = pivot;
        return left;
    }
}
