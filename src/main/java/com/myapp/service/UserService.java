package com.myapp.service;

import com.myapp.persistence.UserEntity;

public interface UserService {

    void save(UserEntity user);

    UserEntity findByUsername(String username);
}
