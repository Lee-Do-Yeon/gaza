package com.idle.gaza.api.service;

import com.idle.gaza.api.request.UserUpdateRequest;
import com.idle.gaza.db.entity.GuideDocument;
import com.idle.gaza.db.entity.User;
import com.idle.gaza.db.repository.GuideDocumentRepository;
import com.idle.gaza.db.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    GuideDocumentRepository guideDocumentRepository;

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
        return userRepository.login(id);
    }

    @Override
    public User searchUser(String id) {
        //유저 정보 리턴
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public int changeState(String id, String state) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) return 0;

        User updateUser = user.get();

        updateUser.setState(state);

        userRepository.save(updateUser);

        return 1;
    }

    @Override
    public int registerGuide(String id, GuideDocument guideDocument) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) return 0;

        User resultUser = user.get();

        guideDocument.setUser(resultUser);

        guideDocumentRepository.save(guideDocument);

        return 1;
    }

    @Override
    public List<GuideDocument> searchGuideRegisterList() {
        Optional<List<GuideDocument>> list = guideDocumentRepository.searchGuideRegisterList();
        return list.orElse(null);
    }

    @Override
    public User searchUserById(String id) {
        //유저 정보 리턴
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public int updateUser(String id, UserUpdateRequest userUpdateRequest) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) return 0;

        User updateUser = user.get();

        updateUser.setName(updateUser.getName());
        updateUser.setPhone_number(updateUser.getPhone_number());
        updateUser.setPicture(updateUser.getPicture());
        updateUser.setEmail(updateUser.getEmail());
        updateUser.setEmail_domain(updateUser.getEmail_domain());

        userRepository.save(updateUser);

        return 1;
    }

    @Override
    public int updatePassword(String id, String password) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) return 0;

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        password = bCryptPasswordEncoder.encode(password);

        User updateUser = user.get();

        updateUser.setPassword(password);

        userRepository.save(updateUser);

        return 1;
    }

    @Override
    public int deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) return 0;

        User updateUser = user.get();

        updateUser.setState("US5");

        userRepository.save(updateUser);

        return 1;
    }
}
