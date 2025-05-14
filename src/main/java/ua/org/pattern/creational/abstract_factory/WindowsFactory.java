package ua.org.pattern.creational.abstract_factory;

public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

interface Button {
    void render();
}

interface Checkbox{
    void paint();
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Windows Checkbox");
    }
}