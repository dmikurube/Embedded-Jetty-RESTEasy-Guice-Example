package service;


public class User {
    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public final String name;
}
