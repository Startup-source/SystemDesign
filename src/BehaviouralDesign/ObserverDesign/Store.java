package BehaviouralDesign.ObserverDesign;

import BehaviouralDesign.ObserverDesign.Observable.IphoneObservableImpl;
import BehaviouralDesign.ObserverDesign.Observable.StockObservable;
import BehaviouralDesign.ObserverDesign.Observer.EmailAlertObserverImpl;
import BehaviouralDesign.ObserverDesign.Observer.MobileAlertObserverImpl;
import BehaviouralDesign.ObserverDesign.Observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] arg) {
        StockObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("abc@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz_userName", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
        iphoneStockObservable.setStockCount(0);
        iphoneStockObservable.setStockCount(5);
    }
}
