package ua.org.pattern.creational.singleton;

public final class SingletonV1 {
    private static volatile SingletonV1 instance;

    private SingletonV1() {
    }

    public static SingletonV1 getInstance() {
        if (instance == null) {
            synchronized (SingletonV1.class) {
                if (instance == null) {
                    instance = new SingletonV1();
                }
            }
        }
        return instance;
    }
}

