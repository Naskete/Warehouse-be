package com.naskete.manage.service.Imp;

import com.naskete.manage.dao.UserDao;
import com.naskete.manage.entity.User;
import com.naskete.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void updateUser(User user) {
        userDao.save(user);
    }
}
