package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto join(UserDto userDto);

    Optional<UserDto> login(String userId);

    List<UserDto> selectUserList(UserDto userDto);
}
