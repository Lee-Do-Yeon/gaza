package com.idle.gaza.api.service;

import com.idle.gaza.api.request.UserUpdateRequest;
import com.idle.gaza.db.entity.GuideDocument;
import com.idle.gaza.db.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User join(User user);

    Optional<User> login(String id);

    User searchUserById(String id);

    User searchUser(Integer userId);

    int changeState(Integer userId, String state);

    int registerGuide(Integer userId, GuideDocument guideDocument);

    int updateUser(Integer userId, UserUpdateRequest userUpdateRequest);

    int updatePassword(Integer userId, String password);

    int deleteUser(Integer userId);
}
