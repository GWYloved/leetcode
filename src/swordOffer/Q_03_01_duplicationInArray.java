package swordOffer;

public class Q_03_01_duplicationInArray {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */
    public static boolean contain(int[][] input, int number){
       if (input.length == 0){
           return false;
       }
       int height = input.length;
       int width = input[0].length;
       if (input[0][0] > number || input[height-1][width-1] < number){
           return false;
       }
       int selectColumn = 0;
       int selectLine = 0;
       for (int i = 0; i < width; i ++){
           if (input[selectLine][i] > number){
               break;
           }
           if (input[selectLine][i] == number){
               return true;
           }
           selectColumn = i;
       }
       for (int i = 0; i < height; i ++){
           if (number == input[selectColumn][i]){
               return true;
           }
           if (number < input[selectColumn][i]){
               return false;
           }
       }
       return false;
    }
}
