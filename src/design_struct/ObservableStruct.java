package design_struct;

import java.util.Observable;
import java.util.Observer;

public class ObservableStruct {
    public class ObserverObject implements Observer{
        //观察者
        @Override
        public void update(Observable observable, Object o) {
            //do update
            System.out.println("args = "+o);
        }
    }

    public class SubscriberObject extends Observable{
        //被观察者
        public SubscriberObject() {
            super();
        }

        @Override
        public synchronized void addObserver(Observer observer) {
            super.addObserver(observer);
            //添加观察者
        }

        @Override
        public synchronized void deleteObserver(Observer observer) {
            super.deleteObserver(observer);
            //删除观察者
        }

        @Override
        public void notifyObservers() {
            super.notifyObservers();
            //通知所有的观察者，自己变化了，是时候更新了
        }

        @Override
        public void notifyObservers(Object o) {
            super.notifyObservers(o);
            //通知单一观察者进行更新
        }

        @Override
        public synchronized void deleteObservers() {
            super.deleteObservers();
            //删除观察者
        }

        @Override
        protected synchronized void setChanged() {
            super.setChanged();
            //设置以更改，如果是的话，在调用更新观察者的时候会执行
        }

        @Override
        protected synchronized void clearChanged() {
            super.clearChanged();
            //设置未更改，如果设置了，之后没有调用setChanged的话是不会更新观察者的
        }

        @Override
        public synchronized boolean hasChanged() {
            return super.hasChanged();
            //查看是否更改
        }

        @Override
        public synchronized int countObservers() {
            return super.countObservers();
            //返回观察者数量
        }
    }

    public void test() {
        SubscriberObject subscriberObject = new SubscriberObject();
        ObserverObject o1 = new ObserverObject();
        ObserverObject o2 = new ObserverObject();
        subscriberObject.addObserver(o1);
        subscriberObject.addObserver(o2);
        subscriberObject.notifyObservers("hehe");
    }

    public static void main(String[] args) {

    }
}
