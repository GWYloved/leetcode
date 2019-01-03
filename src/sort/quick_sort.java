package sort;

import java.util.Arrays;

class quick_sort {
    /**
     * 前后指针快排法
     */
    public static void quickSortByTwoPointer(int[] a,int startIndex, int endIndex){
        if (startIndex >= endIndex){
            return;
        }
        int partitionIndex = getPartitionIndexByTwoPointer(a,startIndex,endIndex);
        quickSortByTwoPointer(a, startIndex, partitionIndex-1);
        quickSortByTwoPointer(a, partitionIndex + 1, endIndex);
    }

    private static int getPartitionIndexByTwoPointer(int[] a, int startIndex, int endIndex){
        int left = startIndex;
        int right = endIndex;
        int pivot = a[startIndex];
        while (left != right){
            while (left < right && a[right] > pivot){
                right --;
            }
            while (left < right && a[left] <= pivot){
                left ++;
            }
            System.out.println("left = "+left + "// right = "+right);
            if (left < right){
                a[left] = a[left] + a[right];
                a[right] = a[left] - a[right];
                a[left] = a[left] - a[right];
            }
            System.out.println("after replace "+Arrays.toString(a));
        }
        System.out.println("before change "+ Arrays.toString(a));
        a[startIndex] = a[left];
        a[left] = pivot;
        System.out.println("after change "+Arrays.toString(a));
        return left;
    }

    public static void quickSortByFillEmpty(int[] a, int startIndex, int endIndex){
        if (startIndex > endIndex){
            return;
        }
        int partitionIndex = getPartitionIndexByFillEmpty(a, startIndex,endIndex);
        quickSortByFillEmpty(a, startIndex, partitionIndex-1);
        quickSortByFillEmpty(a, partitionIndex +1, endIndex);
    }

    private static int getPartitionIndexByFillEmpty(int[] a, int startIndex, int endIndex){
        int index = startIndex;
        int left = startIndex;
        int right = endIndex;
        int pivot = a[startIndex];

        while (left < right){
            while (left < right){
                if (a[right] < pivot){
                    a[index] = a[right];
                    index = right;
                    left ++;
                    break;
                }
                right --;
            }
            while (left < right){
                if (a[left] > pivot){
                    a[index] = a[left];
                    index = left;
                    right --;
                    break;
                }
                left ++;
            }
        }
        a[index] = pivot;
        return index;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,9,1,2,6,5,2,1};
        System.out.println(Arrays.toString(a));
        quickSortByTwoPointer(a,0, a.length-1);
        System.out.println(Arrays.toString(a));
//        int a = 1;
//        int b = 2;
//        a = a + b;
//        b = a - b;
//        a = a - b;
//        System.out.println(a);
//        System.out.println(b);
    }
}
