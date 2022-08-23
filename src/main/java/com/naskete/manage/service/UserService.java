package com.naskete.manage.service;

import com.naskete.manage.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User FindByUsername(String username);

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    Optional<User> FindById(Integer id);
}
