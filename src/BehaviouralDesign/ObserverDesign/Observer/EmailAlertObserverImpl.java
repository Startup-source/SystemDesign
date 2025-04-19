package BehaviouralDesign.ObserverDesign.Observer;

import BehaviouralDesign.ObserverDesign.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "product is in stock hurry up!");
    }

    private void sendEmail(String emailId, String msg) {
        System.out.println("mail sent to : "+emailId+" with msg "+msg);
    }
}
