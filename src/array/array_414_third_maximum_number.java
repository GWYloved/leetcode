package array;

import java.util.HashSet;
import java.util.Set;

public class array_414_third_maximum_number {
    public int thirdMax(int[] nums) {

    }

    private class NumberContainer{
        int firstBig = Integer.MIN_VALUE,secondBig = Integer.MIN_VALUE,thirdBig = Integer.MIN_VALUE;
        public void insert(int number){
            if (firstBig == number || secondBig == number || thirdBig == number){
                return;
            }
            if (firstBig == Integer.MIN_VALUE){
                firstBig = number;
            }
        }

        private class Wrapper{
            int flag;
            int temp;
            public static final int NOTHING = 0;
            public static final int BIGGER = 1;
            public static final int LITTER = 2;
            public static final int JUST_REPLACE = 3;
            public Wrapper(int flag) {
                this.flag = flag;
            }

            public Wrapper(int flag, int temp) {
                this.flag = flag;
                this.temp = temp;
            }

            public int getTemp() {
                return temp;
            }
        }

        private Wrapper insertFirst(int number){
            if (firstBig == number){
                return new Wrapper(Wrapper.NOTHING);
            }
            if (firstBig < number){
                Wrapper wrapper = new Wrapper(Wrapper.LITTER, firstBig);
                firstBig = number;
                return wrapper;
            }
            if (firstBig > number){
                Wrapper wrapper = new Wrapper(Wrapper.BIGGER, firstBig);
                firstBig = number;
                return wrapper;
            }
            if (firstBig == Integer.MIN_VALUE){
                Wrapper wrapper = new Wrapper(Wrapper.JUST_REPLACE);
                return wrapper;

            }
        }

        private Integer insertSecond(int number){

        }

        private Integer insertThird(int number){

        }
    }
}