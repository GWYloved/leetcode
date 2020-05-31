package swordOffer;

public class c2Singleton {
    //单例默认有饿汉单例，就是创建的时候直接static在成员变量创建，饿汉单例可以直接避免多线程问题
    //单例默认也有懒汉单例，即需要的时候在创建，懒汉单例线程优化最佳是Double-check
    //除了以上，还有静态内部类来进行单例构造。静态方法构同饿汉，利用JVM构造静态对象只能构造一次的特性

    private c2Singleton(){}

    private static class singletonInner{
        private static c2Singleton singleton = new c2Singleton();
    }
    public static c2Singleton getInstance(){
        return singletonInner.singleton;
    }

    /**
     * 由于懒汉单例的doublecheck 不可避免的使用到了volitile，而volitile会影响性能
     * 因此静态内部类是最好的一种实现方式。
     */
}
