package com.nhnacademy.student.repository;


import com.nhnacademy.student.domain.User;
import com.nhnacademy.student.exception.UserAlreadyExistsException;
import com.nhnacademy.student.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public boolean exists(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getUserPassword().equals(password))
                .orElse(false);
    }

    @Override
    public User getUser(String id) {
        return exists(id) ? userMap.get(id) : null;
    }

    @Override
    public User addUser(User user) {
        if (exists(user.getUserId())) {
            throw new UserAlreadyExistsException();
        }
        userMap.put(user.getUserId(), user);
        return user;
    }

    @Override
    public void modify(User user) {
        User dbUser = getUser(user.getUserId());
        if (Objects.isNull(dbUser)) {
            throw new UserNotFoundException();
        }

        dbUser.setUserName(user.getUserName());
        dbUser.setUserPassword(user.getUserPassword());
    }

}
