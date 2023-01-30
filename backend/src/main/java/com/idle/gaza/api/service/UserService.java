package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User join(User user);

    Optional<User> login(String userId);

    List<User> selectUserList(User user);
}
