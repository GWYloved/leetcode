package thinkInJava.chapter7;

import java.util.Random;

/**
 * Created by YinPengcheng on 2020-03-23 16:34 email: mikilangkilo.yin@ximalaya.com
 */
public class Final7P8P1Demo {

    private static Random rand = new Random(47);
    private String id;

    public Final7P8P1Demo(String id) {
        this.id = id;
    }

    //测试常亮
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    private static final int VALUE_THREE = 39;
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    //测试变量
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    //测试数组
    private final int[] a = {1, 2, 3, 4, 5, 6};

    public String toString() {
        return id + ": " + "i4 = " + i4 + ",INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        Final7P8P1Demo fd1 = new Final7P8P1Demo("fd1");
//!        fd1.valueOne++;//编译时报错：can not assign a value to final variable
        fd1.v2.i++;
        fd1.v1 = new Value(9);
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }
//!        fd1.v2 = new Value(0);//编译时报错：can not assign a value to final variable
//!        fd1.VAL_3 = new Value(1);//编译时报错：can not assign a value to final variable
//!        fd1.a = new int[3];//编译时报错：can not assign a value to final variable
        System.out.println(fd1);
        System.out.println("creatint new finaldata");
        Final7P8P1Demo fd2 = new Final7P8P1Demo("fd2");
        System.out.println(fd1);
        System.out.println(fd2);
    }

}

class Value {

    int i;//Package access

    public Value(int i) {
        this.i = i;
    }
}
