package ua.org.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;
public class ChatUser implements User {
    private final String name;

    public ChatUser(String name) {
        this.name = name;
    }

    public void receive(String message) {
        System.out.println(name + " отримав(ла): " + message);
    }
}
class ChatRoom implements Chat {
    private final List<User> users = new ArrayList<>();

    public void subscribe(User user) {
        users.add(user);
    }

    public void unsubscribe(User user) {
        users.remove(user);
    }

    public void sendMessage(String message) {
        for (User user : users) {
            user.receive(message);
        }
    }
}

// Суб'єкт (Observable)
interface Chat {
    void subscribe(User user);
    void unsubscribe(User user);
    void sendMessage(String message);
}

// Спостерігач (Observer)
interface User {
    void receive(String message);
}

class Main3 {
    public static void main(String[] args) {
        ChatRoom chat = new ChatRoom();

        User alice = new ChatUser("Аліса");
        User bob = new ChatUser("Боб");

        chat.subscribe(alice);
        chat.subscribe(bob);

        chat.sendMessage("Привіт усім!");

        chat.unsubscribe(bob);

        chat.sendMessage("Це бачить лише Аліса");
    }
}
