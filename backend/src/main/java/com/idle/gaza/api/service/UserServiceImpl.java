package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.User;
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

    public User join(User user) {
        return userRepository.save(user);
    }

    /**
     * 로그인 구현체
     *
     * @param id String
     * @return Optional<UserDto>
     */
    @Override
    public Optional<User> login(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> selectUserList(User user) {
        return null;
    }
}
