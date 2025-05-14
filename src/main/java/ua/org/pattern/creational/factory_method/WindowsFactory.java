package ua.org.pattern.creational.factory_method;

interface Button {
    void render();
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("Windows Button");
    }
}

class LinuxButton implements Button {
    public void render() {
        System.out.println("Linux Button");
    }
}