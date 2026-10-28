package com.korai.servletstudy2.service;

import com.korai.servletstudy2.exception.DuplicateException;
import com.korai.servletstudy2.model.User;
import com.korai.servletstudy2.repository.UserRepository;

import java.util.List;

public class UserService {
    private static UserService instance;
    private UserRepository UserRepository;

    private UserService(UserRepository userRepository) {
        this.UserRepository = userRepository;
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService(com.korai.servletstudy2.repository.UserRepository.getInstance());
        }
        return instance;
    }


    public void register(User user) throws RuntimeException {
        if (isDuplicatedUsername(user.getUsername())) {
            throw new DuplicateException("이미 존재하는 사용자이름입니다");
        }
        UserRepository.insert(user);
    }

    public boolean isDuplicatedUsername(String username) {
        return UserRepository.findByUsername(username) != null;
    }

    public List<User> getUserAll() {
        return UserRepository.findAll();
    }
}
