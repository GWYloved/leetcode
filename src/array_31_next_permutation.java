import java.util.Arrays;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
/*
题目的意思是，给定一个序列，我们来更改顺序，使得新的顺序生成的数值比之前的大，但是假如给的已经是最大的，就逆序一下就好了。
 */
class array_31_next_permutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 0){
            return;
        }
        //首先判断是否是最大的顺序,判断顺序采用逆序的方式来进行判断，相当于从个位往高位进行索引，切记不能从高位往个位索引
        int temp_lower = nums[nums.length - 1];
        for (int i = nums.length - 2; i >=0; i --){
            if (temp_lower <= nums[i]){
                //低位小于高位，是正常现象
                temp_lower = nums[i];
            }else {
                //出现低位大于高位
                if (i == nums.length -2){
                    //1.此时没有比低位更低的低位，则直接翻转高位和低位即可
                    nums[nums.length -1] = nums[nums.length-2];
                    nums[nums.length -2] = temp_lower;
                    return;
                }else {
                    //2.此时低位并非是最低位，则需要比较低位的更低位和高位的关系
                    int index = i+2;
                    Arrays.sort(nums,index,nums.length);
                    while (index <nums.length){
                        if (nums[index] > nums[i]){
                            int temp = nums[index];
                            nums[index] = nums[i];
                            nums[i] = temp;
                            //此时已翻转完毕，但是需要将num[index]的低位数字进行重排序
                            Arrays.sort(nums,i+1,nums.length);
                            return;
                        }else {
                            index++;
                        }
                    }
                    //3.此时高位已全部大于低位，此时需要将该值与高位互换，之后重排高位的末位值
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    Arrays.sort(nums,i+1, nums.length);
                    return;
                }
            }
        }
        //该数组就是正常的最大数组，此时按顺序重排一下
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,2};
//        Arrays.sort(a,1,3);
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 解题思路：写了我2小时才把这题做掉，整体的思路其实比较简单，就是由尾部往头部索引，找到出现尾部比头部大的项，然后针对该项的前项a，
     * 找到该项后面的比a大的最小的值，然后将它和a对调，然后将a后面的所有数字全部重新排序一下即可
     */
}
