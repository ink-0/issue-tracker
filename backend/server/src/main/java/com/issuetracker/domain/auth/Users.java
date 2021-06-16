package com.issuetracker.domain.auth;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public List<User> toList() {
        return users;
    }
}
