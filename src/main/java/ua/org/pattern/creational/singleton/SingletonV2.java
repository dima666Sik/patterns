package ua.org.pattern.creational.singleton;

public final class SingletonV2 {
    private static final SingletonV2 INSTANCE = new SingletonV2();

    private SingletonV2() {
    }

    public static SingletonV2 getInstance() {
        return SingletonV2.INSTANCE;
    }
}

