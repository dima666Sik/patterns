package ua.org.pattern.creational.builder;

import lombok.ToString;

@ToString
public class User {
    private String name;
    private int age;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

class Main{
    public static void main(String[] args) {
        User user = new User.Builder().setName("test").setAge(23).build();
        System.out.println(user);
    }
}