package com.naskete.manage.dao;

import com.naskete.manage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE username = ?", nativeQuery = true)
    User findByUsername(String username);

    @Query(value = "UPDATE user SET username = ?2, password = ?3, telephone = ?4 WHERE uid = ?1", nativeQuery = true)
    @Transactional
    @Modifying
    void update(Integer uid, String username, String password, String telephone);
}
