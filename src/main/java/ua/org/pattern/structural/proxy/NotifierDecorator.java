package ua.org.pattern.structural.proxy;

public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrapper;

    NotifierDecorator(Notifier notifier) {
        this.wrapper = notifier;
    }

    @Override
    public void send(String message) {
        wrapper.send(message); // делегуємо базовій реалізації
    }
}

class Main2 {
    public static void main(String[] args) {
        Notifier notifier = new SimpleNotifier(); // базовий
        notifier = new SMSNotifier(notifier);     // додаємо SMS
        notifier = new EmailNotifier(notifier);   // додаємо Email

        notifier.send("Your order has been shipped!");
    }
}

class EmailNotifier extends NotifierDecorator {
    public EmailNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Email with message: " + message);
    }
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS with message: " + message);
    }
}

class SimpleNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending message: " + message);
    }
}

interface Notifier {
    void send(String message);
}
