package com.naskete.manage.dao;

import com.naskete.manage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE username = ?", nativeQuery = true)
    User findByUsername(String username);
}
