package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.UserDto;
import com.idle.gaza.db.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public UserDto join(UserDto userDto) {
        return userRepository.save(userDto);
    }

    /**
     * 로그인 구현체
     *
     * @param String userId
     * @return Optional<UserDto>
     */
    @Override
    public Optional<UserDto> login(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<UserDto> selectUserList(UserDto userDto) {
        return null;
    }
}
