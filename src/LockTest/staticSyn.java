package LockTest;

public class staticSyn {
    volatile int t = 0;
    public static synchronized int onSynStatic(){
        int i = 0;
        i ++;
        return i;
    }

    public synchronized int onSyn(){
        synchronized (this){
            int i = 0;
            i ++;
            return i;
        }
    }

    public static void main(String[] args) {
        onSynStatic();
        new staticSyn().onSyn();
        new staticSyn().t++;
    }
}
