package com.naskete.manage.service.Imp;

import com.naskete.manage.dao.UserDao;
import com.naskete.manage.entity.User;
import com.naskete.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User FindByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public Optional<User> FindById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void updateUser(Integer uid, String username, String password, String telephone) {
        userDao.update(uid, username, password, telephone);
    }
}
