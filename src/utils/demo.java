package utils;

public class demo {
    public static void main(String[] args) {
        String a = "重地";
        String b = "通话";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        new A(new Boolean(false));
    }

    static class A<T>{
        private T t;
        public A(T b) {
            t = b;
            System.out.println(t.getClass());
        }

        private void onChange(T t){
            System.out.println(t.getClass());
        }
    }
}
