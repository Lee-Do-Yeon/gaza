package com.idle.gaza.api.service;

import com.idle.gaza.api.request.UserUpdateRequest;
import com.idle.gaza.db.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User join(User user);

    Optional<User> login(String id);

    User searchUser(Integer userId);

    List<User> selectUserList(User user);

    int updateUser(Integer userId, UserUpdateRequest userUpdateRequest);

    int updatePassword(Integer userId, String password);

    int deleteUser(Integer userId);
}
