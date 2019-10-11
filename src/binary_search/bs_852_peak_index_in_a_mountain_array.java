package binary_search;

/**
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Example 1:
 *
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 *
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
public class bs_852_peak_index_in_a_mountain_array {
    public static int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1 ;
        while (start < end ){
            int mid = (end - start)/2 + start;
            if (A[mid] > A[mid -1] && A[mid] > A[mid + 1]){
                return mid;
            }
            if (A[mid] > A[mid -1] && A[mid] < A[mid + 1]){
                start = mid;
                continue;
            }
            if (A[mid] < A[mid-1]&& A[mid] > A[mid + 1]){
                end = mid;
                continue;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{1,2,1}));
        System.out.println(peakIndexInMountainArray(new int[]{3,9,13,23,444444444,23,4}));
    }
}
