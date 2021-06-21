package swordOffer;

public class Q_04_duplicationInArray {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */
    public static boolean contain(int[][] input, int number) {
        int heigh = input.length;
        if (heigh == 0){
            return false;
        }
        int width = input[0].length;
        if (width == 0){
            return false;
        }
        int flag_height = heigh - 1;
        int flag_width = 0;
        while (flag_height >= 0 && flag_width < width){
            if (input[flag_height][flag_width] == number){
                return true;
            }
            if (input[flag_height][flag_width] > number){
                flag_height--;
                continue;
            }
            if (input[flag_height][flag_width] < number){
                flag_width ++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[1][1];
        input[0][0] = -5;
        System.out.println(contain(input, -10));
    }
}
